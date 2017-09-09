package course;

public class Introduce {
    public String getGreeting() {
        return "来自信管 1501 江高华的问候！";
    }

    public static void main(String[] args) {
        System.out.println(new Introduce().getGreeting());
    }
}
