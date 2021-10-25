public class Employee {
    String name;
    int age;
    boolean vaccination;

    public Employee (String name, int age, boolean vaccination)
    {
        this.name = name;
        this.age = age;
        this.vaccination = vaccination;
    }

    public void info()
    {
            System.out.print(name + " ");
            System.out.print(age + " ");
            System.out.print(vaccination + "\n");
    }
}
