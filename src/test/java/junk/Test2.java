package junk;

public class Test2 {

    //Дана строка, содержащая полное имя файла (например, 'c:\WebServers\home\testsite\www\myfile.txt').
    // Выделите из этой строки имя файла без расширения.

    public static void main(String[] args) {
        String exmpl = "c:\\WebServers\\home\\testsite\\www\\myfile.txt";

        String name = exmpl.substring(exmpl.lastIndexOf("\\") + 1, exmpl.lastIndexOf("."));
        System.out.println(name);
    }
}
