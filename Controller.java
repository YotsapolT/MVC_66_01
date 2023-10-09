import java.util.Arrays;

public class Controller {
    Model1 model1;
    Model2 model2;
    UserInput usrIn;
    boolean isCodeValid;

    public Controller() {
        model1 = new Model1();
        model2 = new Model2();
    }

    public void getUserInputM1andSendOutput(String strIn, UserInput usrIn) {
        this.usrIn = usrIn;
        isCodeValid = model1.lexer(strIn);
        if (isCodeValid) {
            usrIn.showOutput(model1.getAns());
        } else {
            usrIn.showOutput("Syntax error");
        }
    }

    public void getUserInputM2andSendOutput(String strIn, UserInput usrIn) {
        this.usrIn = usrIn;
        isCodeValid = model2.lexer(strIn);
        if (isCodeValid) {
            usrIn.showOutput(model2.getAns());
        } else {
            usrIn.showOutput("Syntax error");
        }
    }

}
