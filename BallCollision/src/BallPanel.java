import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BallPanel extends JPanel
{
    private ArrayList<Ball> balls = new ArrayList<Ball>();  //小球列表
    private BallComponent component = new BallComponent();  //小球画板
    private JTextField txtNumOfBalls = new JTextField(5); //小球数量输入框
    private JButton btnStartAndStopAndContinue = new JButton("Start");   //Start按钮
    private JButton btnClear = new JButton("Clear");    //Clear按钮
    private JSlider speedSlider = new JSlider(1, 10, 8);    //速度滑块
    private JComboBox<String> ballCombo = new JComboBox<>();  //小球选择框
    private JButton btnDrawTrace = new JButton("DrawTrace"); // 画出轨迹按钮
    private JTable dataTable = new JTable();    //表格
    private BallThread thread = new BallThread();   //小球运动线程
    private int delay = 5;  //小球运动的延缓时间
    private boolean[] isDrawTrace = new boolean[10];    // 是否画出小球轨迹

    /**
     * 初始化小球面板
     */
    public BallPanel()
    {
        setLayout(new BorderLayout());  //设置为BorderLayout的布局
        add(component, BorderLayout.CENTER);    //将小球画板加到面板中央
        component.setOpaque(true);              //设置画板不透明，以便能添加背景色
        component.setBackground(Color.LIGHT_GRAY);   //设置背景色

        JPanel panel = new JPanel();    //创建用来放各种按钮的面板
        panel.add(new JLabel(" The number of balls (1-100): "));  //添加标签number:
        panel.add(txtNumOfBalls);              //将小球数量输入框放入该面板
        panel.add(btnStartAndStopAndContinue);  //将Start/Stop/Continue按钮放入该面板
        panel.add(btnClear);            //将Clear按钮放入该面板
        panel.add(new JLabel(" Speed: "));  //添加标签Speed:
        panel.add(speedSlider);             //添加速度滑块
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel, BorderLayout.SOUTH); //将按钮面板加到主面板南部

        JPanel panelEast = new JPanel(new BorderLayout());    //创建数据展示面板
        JPanel subPanelNorth = new JPanel();
        subPanelNorth.add(new JLabel("Ball ID: "));
        subPanelNorth.add(ballCombo);
        subPanelNorth.add(btnDrawTrace);
        panelEast.add(subPanelNorth, BorderLayout.NORTH);
        JScrollPane scroll = new JScrollPane(dataTable);
        scroll.setSize(300, 200);
        panelEast.add(scroll, BorderLayout.CENTER);
        add(panelEast, BorderLayout.EAST);


        // 设置输入框的初始值为5
        txtNumOfBalls.setText("20");

        // 设置速度滑块属性
        //speedSlider.setMajorTickSpacing(2); // 设置主刻度间隔
        //speedSlider.setMinorTickSpacing(1); // 设置次刻度间隔
        //speedSlider.setPaintTicks(true);    // 绘制刻度和标签
        //speedSlider.setPaintLabels(true);

        btnClear.setEnabled(false);
        ballCombo.setEnabled(false);
        btnDrawTrace.setEnabled(false);


        // 为输入框添加监听器
        txtNumOfBalls.getDocument().addDocumentListener(new DocumentListener()
        {
            /**
             * 实现DocumentListener接口中insertUpdate方法
             * 该方法可以跟踪文本框中输入的内容
             */
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                changedUpdate(e);
            }

            /**
             * 实现DocumentListener接口removeUpdate方法
             * 该方法可以跟踪文本框中移除的内容，例如：在文本框中点击Backspace
             */
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                changedUpdate(e);
            }

            /**
             * 实现DocumentListener接口changedUpdate方法
             * 该方法可以跟踪当文本框中已存在的内容改变时，获取相应的值
             */
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                Document doc = e.getDocument();
                String str = "";
                try
                {
                    str = doc.getText(0, doc.getLength()); //返回文本框输入的内容
                } catch (BadLocationException e1)
                {
                    e1.printStackTrace();
                }
                if (str != null && !"".equals(str.trim()) && str.matches("^[0-9]*$") && Integer.valueOf(str.trim()) <= 100)
                {
                    btnStartAndStopAndContinue.setEnabled(true);
                } else
                {
                    btnStartAndStopAndContinue.setEnabled(false);
                }
            }
        });
        //Stop/Continue按钮加入监听器，当按下按钮时暂停/继续动画
        btnStartAndStopAndContinue.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                if (btnStartAndStopAndContinue.getText().equals("Start"))   // 如果当前按钮的值为Start
                {
                    int num = Integer.valueOf(txtNumOfBalls.getText().trim()); //获取输入框的值，即小球数量
                    ballCombo.addItem("   ");
                    for (int i = 0; i < num; i++)
                    {
                        component.addBall(i + 1);   //创建num个小球
                        if (i < 10) ballCombo.addItem("   " + (i + 1));       //动态增加小球下拉框
                    }
                    thread.setStop(false); //将stop标志置为false
                    txtNumOfBalls.setEnabled(false); //关闭输入框
                    btnStartAndStopAndContinue.setText("Stop"); //将按钮的标签变为Stop
                    ballCombo.setEnabled(true);
                    btnClear.setEnabled(true);
                } else if (btnStartAndStopAndContinue.getText().equals("Stop"))    //如果当前按钮的值为Stop
                {
                    thread.setStop(true);   //将stop标志置为true
                    btnStartAndStopAndContinue.setText("Continue"); //将按钮的标签变为Continue
                } else
                {
                    thread.setStop(false);  //将stop标志置为false
                    btnStartAndStopAndContinue.setText("Stop"); //将按钮的标签变为Stop
                }
            }
        });
        //Clear按钮加入监听器，当按下按钮时清空画板
        btnClear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                balls = new ArrayList<>();      //将球的列表清空
                isDrawTrace = new boolean[10];
                component.repaint();            //重画画板
                txtNumOfBalls.setEnabled(true); //开启输入框
                txtNumOfBalls.setText("");
                btnStartAndStopAndContinue.setText("Start"); //将按钮的标签变为Start
                ballCombo.removeAllItems();     //清空小球下拉框
                ballCombo.setEnabled(false);
                btnClear.setEnabled(false);
            }
        });
        // 添加速度滑块刻度改变监听器
        speedSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                delay = 11 - speedSlider.getValue();
            }
        });
        // 面板大小调整时加入监听器
        this.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                super.componentResized(e);
                // 当重新调整窗口大小时，检查小球是否在圆内。如果不在，则重新放进去
                component.check();
            }
        });
        //小球选择框加入监听器，动态显示小球数据
        ballCombo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                String strVal = (String) ballCombo.getSelectedItem();
                if (strVal != null && !strVal.trim().equals(""))
                {
                    int ballId = Integer.valueOf(strVal.trim());
                    List<Collision> cols = balls.get(ballId - 1).getCollisions();
                    String startLocation = "(" + Math.round(cols.get(0).getX() * 100) / 100.0 + "," + Math.round(cols.get(0).getY() * 100) / 100.0 + ")";
                    int colBallNum = 0;
                    int colBounNum = 0;
                    for (Collision c : cols)
                    {
                        if (c.getKind() == 0) colBounNum++;
                        else if (c.getKind() == 1) colBallNum++;
                    }
                    // 设置表格头
                    Vector vName = new Vector();
                    vName.add("Attributes");
                    vName.add("Value");
                    // 设置表格内容
                    Vector vData = new Vector();
                    Vector vRow = new Vector();
                    vRow.add("Ball ID");
                    vRow.add(ballId);
                    vData.add(vRow);
                    vRow = new Vector();
                    vRow.add("The start location");
                    vRow.add(startLocation);
                    vData.add(vRow);
                    vRow = new Vector();
                    vRow.add("The times of collision with other balls");
                    vRow.add(colBallNum);
                    vData.add(vRow);
                    vRow = new Vector();
                    vRow.add("The times of collision with the boundary");
                    vRow.add(colBounNum);
                    vData.add(vRow);
                    vRow = new Vector();
                    vRow.add("The total times of collision");
                    vRow.add(colBallNum + colBounNum);
                    vData.add(vRow);
                    DefaultTableModel model = new DefaultTableModel(vData, vName);
                    dataTable.setModel(model);

                    // 设置画图按钮为可见
                    btnDrawTrace.setEnabled(true);

                    // 更新btnDrawTrace
                    if (isDrawTrace[ballId - 1]) btnDrawTrace.setText("RemoveTrace");
                    else btnDrawTrace.setText("DrawTrace");
                } else
                {
                    btnDrawTrace.setEnabled(false); // 设置画图按钮为不可见
                }
            }
        });
        btnDrawTrace.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String strVal = (String) ballCombo.getSelectedItem();
                if (strVal == null || strVal.trim().equals("")) return;
                int ballId = Integer.valueOf(strVal.trim());
                if (btnDrawTrace.getText().equals("DrawTrace"))
                {
                    isDrawTrace[ballId - 1] = true;
                    btnDrawTrace.setText("RemoveTrace");
                    component.repaint();    //重画画板
                } else
                {
                    isDrawTrace[ballId - 1] = false;
                    btnDrawTrace.setText("DrawTrace");
                    component.repaint();    //重画画板
                }
            }
        });

        thread.start(); //画画板的线程开始
    }

    /**
     * 主函数，主要用于测试
     *
     * @param args
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new JFrame("Hit Balls"); //设置测试框架的标题
                frame.add(new BallPanel());     //将小球碰撞动画面板放上去
//                frame.setSize(800, 800);        //设置框架大小
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //设置框架的默认关闭方式
                frame.setLocationByPlatform(true);  //将框架的定位交给系统实现
                frame.setVisible(true);         //设置框架可见
            }
        });
    }

    /**
     * 小球运动线程
     */
    private class BallThread extends Thread
    {
        private boolean isStop = true; //停止标记

        /**
         * 线程体
         */
        public void run()
        {
            while (true)    //让它一直执行
            {
                if (!isStop)    //当没有停止的时候
                {
                    for (int i = 0; i < balls.size(); i++)
                    {
                        balls.get(i).move(component.getCircleX(), component.getCircleY(), component.getRadius());   //每个小球都移动一遍
                    }
                    component.repaint();    //重画画板
                }
                try
                {
                    Thread.sleep(delay);    //线程延缓delay毫秒
                } catch (InterruptedException e)
                {  //捕获异常
                    e.printStackTrace();    //处理异常
                }
            }
        }

        /**
         * 设置stop标志
         *
         * @param isStop 是否停止
         */
        public void setStop(boolean isStop)
        {
            this.isStop = isStop;
        }
    }

    /**
     * 小球的画板
     */
    private class BallComponent extends JComponent
    {
        private double circleX = 0; // 小球运动的圆形边界的圆心坐标X
        private double circleY = 0; // 小球运动的圆形边界的圆心坐标Y
        private double radius = 0;  // 小球运动的圆形边界的半径

        public double getCircleX()
        {
            return circleX;
        }

        public double getCircleY()
        {
            return circleY;
        }

        public double getRadius()
        {
            return radius;
        }

        public BallComponent()
        {
            // 用于背景色
            setUI(new ComponentUI()
            {
                public void installUI(JComponent c)
                {
                    super.installUI(c);
                    LookAndFeel.installColors(c, "Panel.background",
                            "Panel.foreground");
                }
            });
        }

        /**
         * 添加小球
         */
        public void addBall(int id)
        {
            double x, y;

            Color[] colors = {Color.green, Color.CYAN, Color.ORANGE, Color.MAGENTA, Color.PINK,
                    Color.YELLOW, Color.RED, new Color(128, 0, 0), new Color(244, 164, 96), new Color(135, 206, 250)};
            Color color;
            if (id <= 10)
            {
                x = circleX + Ball.SIZE * id * 2;
                y = circleY;
                color = colors[id - 1];  //小球的颜色

            } else
            {
                x = circleX + (Math.random() * 2 - 1) * (radius - Ball.SIZE / 2);   //小球开始的随机x坐标
                double temp = Math.pow(Math.pow(radius - Ball.SIZE / 2, 2) - Math.pow(x - circleX, 2), 0.5);
                y = circleY + (Math.random() * 2 - 1) * temp;   //小球开始的随机y坐标
                color = Color.WHITE;
            }

            balls.add(new Ball(id, x, y, color));   //在小球的列表中加入新球，球的初始方位和颜色为前面的值
        }

        /**
         * 检查小球是否在圆内，如果不在，则重新放进圆内
         */
        public void check()
        {
            for (Ball ball : balls)
            {
                ball.check(component.getCircleX(), component.getCircleY(), component.getRadius());
            }
        }

        /**
         * 绘制画板
         */
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            // 画出小球运动的圆形范围
            Rectangle rec = component.getBounds();
            double width = rec.getWidth();
            double height = rec.getHeight();
            double minX = rec.getMinX();
            double minY = rec.getMinY();
            circleX = (minX + rec.getMaxX()) / 2;
            circleY = (minY + rec.getMaxY()) / 2;
            g2.setColor(Color.black);
            if (width > height)
            {
                g2.fill(new Ellipse2D.Double(minX + (width - height) / 2, minY, height, height));
                radius = height / 2;
            } else
            {
                g2.fill(new Ellipse2D.Double(minX, minY + (height - width) / 2, width, width));
                radius = width / 2;
            }
            // 将小球列表中的小球都画到画板上
            for (int i = 0; i < balls.size(); i++)
            {
                Ball ball = balls.get(i);
                g2.setColor(ball.getColor());   //设置画布中小球的颜色
                g2.fill(ball.getShape());       //画出小球的形状
                if (ball.getId() <= 10)
                {
                    g2.setColor(Color.BLUE);    // 设置编号颜色
                    g2.drawString(ball.getId() + "", (float) ball.getX() - 3, (float) ball.getY() + 5); // 添加前十个小球的编号
                }
            }
            // 画出小球轨迹
            for (int i = 0; i < isDrawTrace.length; i++)
            {
                if (isDrawTrace[i])
                {
                    List<Collision> cols = balls.get(i).getCollisions();
                    int[] xPoints = new int[cols.size()];
                    int[] yPoints = new int[cols.size()];
                    for (int j = 0; j < cols.size(); j++)
                    {
                        xPoints[j] = (int) cols.get(j).getX();
                        yPoints[j] = (int) cols.get(j).getY();
                    }
                    g2.setColor(balls.get(i).getColor());
                    g2.drawPolyline(xPoints, yPoints, cols.size());
                }
            }
        }
    }

    /**
     * 小球类
     */
    private class Ball
    {
        private int id; //小球编号
        public static final double SIZE = 20;  //小球的直径
        private double x = 0;   //小球圆心所在的x坐标
        private double y = 0;   //小球圆心所在的y坐标
        private double vx = Math.random() * 2 - 1;   //小球在x轴的速度，范围是-1 < vx < 1，满足(vx*vx + vy*vy == 1)
        private double vy = (Math.random() > 0.5 ? 1 : -1) * Math.pow(1 - vx * vx, 0.5);   //小球在y轴的速度，范围是-1 < vy < 1，满足(vx*vx + vy*vy == 1)
        private Color color = Color.RED;      //小球的颜色
        private List<Collision> collisions = new ArrayList<>(); //小球的碰撞情况，第一个元素表示小球初始位置，不属于碰撞范围内

        /**
         * 小球的构造函数
         *
         * @param id    小球编号
         * @param x     小球所在的x坐标
         * @param y     小球所在的y坐标
         * @param color 小球的颜色
         */
        public Ball(int id, double x, double y, Color color)
        {
            this.id = id;
            this.x = x;
            this.y = y;
            this.color = color;
            if(id <= 10)
            {
                this.vx = 0;
                this.vy = 1;
            }
            collisions.add(new Collision(-1, x, y, -1));
        }

        /**
         * 小球在一个圆形边框中移动
         *
         * @param cirX   圆形边框圆心X坐标
         * @param cirY   圆形边框圆心Y坐标
         * @param radius 圆形边框半径
         */
        public void move(double cirX, double cirY, double radius)
        {
            x += vx;    //小球在x轴上的位移
            y += vy;    //小球在y轴上的位移

            if ((x - cirX) * (x - cirX) + (y - cirY) * (y - cirY) >=        // 当球与圆心的距离大于圆形边界半径时，
                    (radius - Ball.SIZE / 2) * (radius - Ball.SIZE / 2))    // 可认为球与圆形边界发生碰撞时
            {
                double norVecX = (cirX - x) / Math.pow((cirX - x) * (cirX - x) + (cirY - y) * (cirY - y), 0.5); // 单位法向量的dx
                double norVecY = (cirY - y) / Math.pow((cirX - x) * (cirX - x) + (cirY - y) * (cirY - y), 0.5); // 单位法向量的dy
                double croVecX = -norVecY; // 切线向量的dx
                double croVecY = norVecX;  // 切线向量的dy
                if (vx * croVecX + vy * croVecY < 0)
                {
                    croVecX *= -1;
                    croVecY *= -1;
                }
                double dpNor = vx * norVecX + vy * norVecY;
                double dpNorX = -dpNor * norVecX;
                double dpNorY = -dpNor * norVecY;
                double dpCro = vx * croVecX + vy * croVecY;
                double dpCroX = dpCro * croVecX;
                double dpCroY = dpCro * croVecY;

                x -= vx; // 与边界碰撞后归位，不然随着碰撞次数增多，小球会溢出边界
                y -= vy;
                if (id <= 10) collisions.add(new Collision(0, x, y, 0));  // 添加碰撞记录
                vx = dpNorX + dpCroX;
                vy = dpNorY + dpCroY;
            }

            for (Ball ball : balls)   //判断小球间是否发生碰撞
            {
                if (this.equals(ball))  //自己和自己不碰撞
                    continue;
                if ((ball.x - x) * (ball.x - x) + (ball.y - y) * (ball.y - y) <= SIZE * SIZE)    //当两球间的距离小于直径时，可认为两小球发生了碰撞
                {
                    double degree = Math.atan((y - ball.y) / (x - ball.x)); //获取自己与发生碰撞的小球之间所形成的夹角，因为夹角只能在-pi/2-pi/2之间，所以还需判断两球的x坐标之间的关系
                    if (x > ball.x)      //如果自己的x坐标大于发生碰撞的小球的x坐标，由数学知识可知自己应该往正向运动
                    {
                        vx = Math.cos(degree);
                        vy = Math.sin(degree);
                    } else    //如果自己的x坐标小于发生碰撞的小球的x坐标，由数学知识可知应该朝负向运动
                    {
                        vx = -Math.cos(degree);
                        vy = -Math.sin(degree);
                    }
                    if (id <= 10) collisions.add(new Collision(1, x, y, ball.getId()));   // 添加碰撞记录
                }
            }
        }

        /**
         * 获取小球的形状
         *
         * @return 形状
         */
        public Ellipse2D getShape()
        {
            return new Ellipse2D.Double(x - SIZE / 2, y - SIZE / 2, SIZE, SIZE);
        }

        /**
         * 获取小球的颜色
         *
         * @return 颜色
         */
        public Color getColor()
        {
            return color;
        }

        /**
         * 获取小球编号
         *
         * @return 编号
         */
        public int getId()
        {
            return id;
        }

        /**
         * 获取小球碰撞情况
         *
         * @return 小球碰撞情况
         */
        public List<Collision> getCollisions()
        {
            return collisions;
        }

        /**
         * 判断两个小球是否相同
         */
        public boolean equals(Object object)
        {
            if (this == object) return true;    //如果所指的对象相同，即两小球的确相同
            if (object == null) return false;   //如果要比较的小球不存在，则两小球不同
            if (getClass() != object.getClass()) return false;  //如果自己的类名与另一个对象的类名不同，则两小球不同
            Ball ball = (Ball) object;           //将另一个对象强制转化为小球
            return x == ball.x && y == ball.y && color.equals(ball.color);  //通过方位，颜色判断是否相同
        }

        /**
         * 检查球是否在圆边界内
         *
         * @param cirX   圆形边框圆心X坐标
         * @param cirY   圆形边框圆心Y坐标
         * @param radius 圆形边框半径
         */
        public void check(double cirX, double cirY, double radius)
        {
            if ((x - cirX) * (x - cirX) + (y - cirY) * (y - cirY) > (radius - SIZE / 2) * (radius - SIZE / 2))
            {
                x = cirX + (Math.random() * 2 - 1) * (radius - Ball.SIZE / 2);   //小球开始的随机x坐标
                double temp = Math.pow(Math.pow(radius - Ball.SIZE / 2, 2) - Math.pow(x - cirX, 2), 0.5);
                y = cirY + (Math.random() * 2 - 1) * temp;   //小球开始的随机y坐标
            }
        }

        public double getX()
        {
            return x;
        }

        public double getY()
        {
            return y;
        }
    }

    /**
     * 碰撞记录类
     */
    private class Collision
    {
        private int kind;   //碰撞类型，-1代表小球初始状态，0代表与墙碰撞，1代表与其他球碰撞
        private double x;   //发生碰撞的坐标：x
        private double y;   //发生碰撞的坐标：y
        private int otherBallId = 0;    //碰撞球的编号，如果该值为-1，则表示小球初始状态，无意义；如果该值是0，则代表与墙碰撞

        public Collision(int kind, double x, double y, int otherBallId)
        {
            this.kind = kind;
            this.x = x;
            this.y = y;
            this.otherBallId = otherBallId;
        }

        public int getKind()
        {
            return kind;
        }

        public double getX()
        {
            return x;
        }

        public double getY()
        {
            return y;
        }

        public int getOtherBallId()
        {
            return otherBallId;
        }
    }
}
