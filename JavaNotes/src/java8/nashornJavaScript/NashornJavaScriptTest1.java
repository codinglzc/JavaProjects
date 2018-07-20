package java8.nashornJavaScript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @description: Nashorn 一个 javascript 引擎。
 * <p>
 * 从JDK 1.8开始，Nashorn取代Rhino(JDK 1.6, JDK1.7)成为Java的嵌入式JavaScript引擎。Nashorn完全支持ECMAScript 5.1规范以及一些扩
 * 展。它使用基于JSR 292的新语言特性，其中包含在JDK 7中引入的 invokedynamic，将JavaScript编译成Java字节码。
 * <p>
 * 与先前的Rhino实现相比，这带来了2到10倍的性能提升。
 * @author: Liu Cong
 * @create: Created at 2018-06-09
 */
public class NashornJavaScriptTest1
{
    // Java中调用JavaScript
    // 使用 ScriptEngineManager, JavaScript 代码可以在 Java 中执行
    public static void main(String[] args)
    {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "W3CSchool";
        Integer result = null;

        try
        {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
        } catch (ScriptException e)
        {
            System.out.println("执行脚本错误：" + e.getMessage());
        }

        System.out.println(result);
    }
}
