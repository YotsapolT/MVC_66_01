import java.util.ArrayList;
import java.util.HashMap;

public class Model2 {
    private String ans = "";

    public boolean lexer(String strIn) {
        ans = "<html>";
        ArrayList<String> keywordsAndSigns = new ArrayList<>();
        HashMap<String, Integer> variables = new HashMap<String, Integer>();
        keywordsAndSigns.add("declare");
        keywordsAndSigns.add("+");

        String[] arrStr = strIn.split("[\s\n]");
        for (int i = 0; i < arrStr.length; i++) {
            if (arrStr[i].equals("")) {
            } else {
                if (arrStr[i].indexOf("//") != -1)
                    arrStr[i] = arrStr[i].substring(0, arrStr[i].indexOf("//"));

                if ((keywordsAndSigns.contains(arrStr[i]) || variables.containsKey(arrStr[i])) && arrStr.length > 1) {
                    // start with declare
                    if (arrStr[i].equals("declare")) {
                        if (!arrStr[i + 1].matches("^(?![A-Z=0-9]).*")) {
                            return false;
                        } else {
                            ans = ans + arrStr[i] + " is Keyword and Sign<br/>" + arrStr[i + 1] + " is Variable<br/>";
                            variables.put(arrStr[i + 1], 0);
                            i++;
                            continue;
                        }
                    }

                    // start with variable
                    else {
                        if (arrStr[i + 1].equals("=")) { // found "="
                            if (variables.containsKey(arrStr[i + 2]) && arrStr.length > i + 4) {
                                if (arrStr[i + 3].equals("+")) {
                                    if (variables.containsKey(arrStr[i + 4])) {
                                        ans = ans + arrStr[i] + " is Variable<br/>" + arrStr[i + 1]
                                                + " is Assignment<br/>"
                                                + arrStr[i + 2] + " is Variable<br/>" + arrStr[i + 3]
                                                + " is Keyword and Sign<br/>" + arrStr[i + 4] + " is Variable<br/>";
                                        i = i + 4;
                                        continue;
                                    } else { // found a = b + [c || 1] which "c || 1" is non variable or literal
                                        return false;
                                    }
                                } else { // found a = b [+] "+" not found
                                    return false;
                                }
                            } else if (arrStr.length > i + 2) { // found notVariable it can be literal or non variable
                                try { // after "=" is digit
                                    variables.replace(arrStr[i], Integer.parseInt(arrStr[i + 2])); // assign value
                                    ans = ans + arrStr[i] + " is Variable<br/>" + arrStr[i + 1] + " is Assignment<br/>"
                                            + arrStr[i + 2] + " is Integer<br/>";
                                    i = i + 2;
                                    continue;
                                } catch (NumberFormatException e) { // after "=" isn't variable
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    public String getAns() {
        return ans;
    }
}
