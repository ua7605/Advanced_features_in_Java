package streams;

import lombok.Data;

@Data
public class Person
{
    public String name;
    public Integer money;
    public Integer age;

    public Gender gender;

    public Person(String name, Integer billions)
    {
        this.name = name;
        this.money = billions;
    }

    public Person(String name, Integer age, Gender gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
