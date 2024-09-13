public class Word {
    private String _value;
    private boolean _isFits;
    public Word(){
        _value = "";
        _isFits = true;
    }
    public Word(String value){
        _value = value;
        _isFits = value.matches("(0){0,}(10){0,}");
    }
    public boolean getIsFits(){
        return _isFits;
    }

    public String getValue(){
        return _value;
    }
}
