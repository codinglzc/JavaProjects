package annotation.ASimpleDB;

/**
 * @Description:
 * @Author: lzc
 * @Date: Created at 2018-06-04
 */
@DBTable(name = "MEMBER")
public class Member
{
    @SQLString(30)
    private String firstName;
    @SQLString(50)
    private String lastName;
    @SQLInteger
    private Integer age;
    @SQLString(value = 30, constraints = @Constrains(primaryKey = true))
    private String handle;

    private static int memberCount;

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Integer getAge()
    {
        return age;
    }

    public String getHandle()
    {
        return handle;
    }

    public static int getMemberCount()
    {
        return memberCount;
    }
}
