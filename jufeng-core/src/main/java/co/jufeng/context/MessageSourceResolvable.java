package co.jufeng.context;

public interface MessageSourceResolvable {

	String[] getCodes();

	Object[] getArguments();

	String getDefaultMessage();

}
