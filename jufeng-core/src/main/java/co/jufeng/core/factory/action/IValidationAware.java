package co.jufeng.core.factory.action;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IValidationAware {

	public void setActionErrors(Collection<String> errorMessages);

	public Collection<String> getActionErrors();

	public void setActionMessages(Collection<String> messages);

	public Collection<String> getActionMessages();

	public void setFieldErrors(Map<String, List<String>> errorMap);

	public Map<String, List<String>> getFieldErrors();

	public void addActionError(String anErrorMessage);

	public void addActionMessage(String aMessage);

	public void addFieldError(String fieldName, String errorMessage);

	public boolean hasActionErrors();

	public boolean hasActionMessages();

	public boolean hasErrors();

	public boolean hasFieldErrors();

}