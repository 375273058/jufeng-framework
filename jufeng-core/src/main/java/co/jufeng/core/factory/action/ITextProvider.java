package co.jufeng.core.factory.action;


import java.util.List;
import java.util.ResourceBundle;

import co.jufeng.core.factory.action.util.ValueStack;

public interface ITextProvider {

	public boolean hasKey(String key);

	public String getText(String key);

	public String getText(String key, String defaultValue);

	public String getText(String key, String defaultValue, String obj);

	public String getText(String key, List<?> args);

	public String getText(String key, String[] args);

	public String getText(String key, String defaultValue, List<?> args);

	public String getText(String key, String defaultValue, String[] args);

	public String getText(String key, String defaultValue, List<?> args, ValueStack stack);

	public String getText(String key, String defaultValue, String[] args, ValueStack stack);

	public ResourceBundle getTexts(String bundleName);

	public ResourceBundle getTexts();
}
