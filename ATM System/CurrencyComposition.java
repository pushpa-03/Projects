
public class CurrencyComposition {

    private int FiveHundred, TwoHundred, OneHundred, Fifty, Ten;

    public CurrencyComposition(int FiveHundred, int TwoHundred, int OneHundred, int Fifty, int Ten) {
        this.Ten = Ten;
        this.Fifty = Fifty;
        this.OneHundred = OneHundred;
        this.FiveHundred = FiveHundred;
        this.TwoHundred = TwoHundred;
    }

    public int getTenNote() {
        return this.Ten;
    }

    public int getFiftyNote() {
        return this.Fifty;
    }

    public int getOneHunderedNote() {
        return this.OneHundred;
    }

    public int getTwoHunderedNote() {
        return this.TwoHundred;
    }

    public int getFiveHunderedNote() {
        return this.FiveHundred;
    }

    public void setTenNotes(int ten) {
        this.Ten = ten;
    }

    public void setFiftyNote(int Fifty) {
        this.Fifty = Fifty;
    }

    public void setOneHundredNotes(int OneHundred) {
        this.OneHundred = OneHundred;
    }

    public void setTwoHundredNotes(int TwoHundred) {
        this.TwoHundred = TwoHundred;
    }

    public void setFiveHundredNotes(int FiveHundred) {
        this.FiveHundred = FiveHundred;
    }

}