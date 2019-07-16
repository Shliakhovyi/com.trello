package junk;

public class Test4 {

    //Дан массив названий переменных в camelCase. Преобразовать названия в snake_case. пример массива
    // [myAwsomePhrase, iLoveJustinBieber, captainJackSparrow]

    public static void main(String[] args) {
        String[] exmpl = {"myAwsomePhrase", "iLoveJustinBieber", "captainJackSparrow"};

        for (int i = 0; i < exmpl.length; i++) {
            exmpl[i] = exmpl[i].replaceAll("(.+?)([A-Z])", "$1_$2").toLowerCase();
        }

        for (String res: exmpl) {
            System.out.println(res);
        }

    }
}
