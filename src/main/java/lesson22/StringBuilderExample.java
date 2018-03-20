package lesson22;

class StringBuilderExample {

    static StringBuilder alphabetText = new StringBuilder("0123456789 abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,.");
    static StringBuilder cipherText = new StringBuilder("OPQRSTUVWXYZ,. abcdefghijklwxyzABCDEFGmnopqrstuvHIJKLMN0123456789");

    public static void main(String[] args) {
//        int startOfSubstrIncl = 3;
//        int endOfSubstrExcl = 5;
//        int indexOffset = 4;
//        int charIndex = 4;
//
//        StringBuilder builder = new StringBuilder();
//        builder.append("new ending");
//        builder.delete(startOfSubstrIncl, endOfSubstrExcl);
//        builder.insert(indexOffset, "some sub string");
//        builder.replace(startOfSubstrIncl, endOfSubstrExcl, "replace");
//        builder.setCharAt(charIndex, 'a');
//        String builderString = builder.toString();
//        System.out.print(builderString);

        System.out.print(encode("Nemo"));

    }

    public static String encode (String msg){
        StringBuilder message = new StringBuilder();
        //String name = "Nemo";
        for (int j = 0; j < msg.length(); j++){
            char c = message.charAt(j);
            int  normalIndex = alphabetText.indexOf(c +"");
            char charTOReplace = cipherText.charAt(normalIndex);
            message.setCharAt(j, charTOReplace);

        }
        return message.toString();
    }


}