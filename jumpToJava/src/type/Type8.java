package type;

public class Type8 {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.insert(0, "hi");
        sb.append("jump to java");
        String result = sb.toString();
        System.out.println(result);

        String result2 = "";{
            result2 += "hello";
            result2 += " ";
            result2 += "jump to java";
            System.out.println(result2);


        }
    }
}
