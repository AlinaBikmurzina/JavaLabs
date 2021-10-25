public class Main {
    public static void main(String[] args){
        Employee employee1 = new Employee("Бикмурзина", 42, true);
        Employee employee2 = new Employee("Маннанова", 23, false);
        Employee employee3 = new Employee("Шарифьянов", 45, true);
        Employee employee4 = new Employee("Кузнецов", 34, false);
        Employee employee5 = new Employee("Федоров", 27, false);
        Employee employee6 = new Employee("Михайлова", 19, false);
        Employee employee7 = new Employee("Галлямов", 32, true);
        Employee employee8 = new Employee("Кильдибаев", 37, true);
        Employee employee9 = new Employee("Шарафутдинов", 44, true);
        Employee employee10 = new Employee("Шамсемухаметов", 39, true);

        Employee employees[] = new Employee[] {
                employee1,
                employee2,
                employee3,
                employee4,
                employee5,
                employee6,
                employee7,
                employee8,
                employee9,
                employee10};

        for (int i = 0; i< employees.length; i++){
            if (employees[i].vaccination == true){
                employees[i].info();
            }
        }


    }
}