package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constant.ComConstant;

@Aspect
public class ExceptionHandleAOP {
	@Autowired
	ObjectMapper mapper;

	@Pointcut("execution(* controller.*.*(..))")
	public void exceptionHandler() {
	}

	@AfterThrowing(pointcut = "exceptionHandler()", throwing = "e")
	public void doAfterThrowException(Exception e)
			throws JsonProcessingException, IOException {
		HttpServletResponse response = LoginFilter.responseGlobal;
		ResponseInfo respInfo = new ResponseInfo();
		respInfo.setStatus(false);
		respInfo.setMsg(ComConstant.SYS_ERRO);
		PrintWriter writer = response.getWriter();
		writer.write(this.mapper.writeValueAsString(respInfo));
		IOUtils.closeQuietly(writer);
	}

}
