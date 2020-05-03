package src.category.JianZhiOffer.didi;

public class JZ05_ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ' ') sb.append(c);
            else sb.append("%20");
        }

        return sb.toString();
    }

    //return s.replaceAll(" ", "%20");
}
