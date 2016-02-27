package common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanAssistant implements ApplicationContextAware {
	public static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static <T> T getBean(Class<T> clz) throws BeansException {
		Object result = applicationContext.getBean(clz);
		return (T) result;
	}

}
