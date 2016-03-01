package co.jufeng.core.config;

import java.io.File;
import java.util.Map;

import co.jufeng.core.enums.ConfigTypeEnum;

public interface IConfig {
	
	public void load(Map<ConfigTypeEnum, File> fileMap);

}
