package ad.bot.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Properties;

public class ParametersProvider {

  private static ParametersProvider instance;

  private ArrayList<Properties> propertiesList = new ArrayList<>();

  private ParametersProvider() {
    propertiesList.add(loadProperty("configuration/default.property"));
  }

  private static ParametersProvider getInstance() {
    if (instance == null) {
      instance = new ParametersProvider();
    }
    return instance;
  }

  private Properties loadProperty(String path) {
    Properties properties = new Properties();
    try {
      File file = new File(path);
      FileInputStream fileInputStream = new FileInputStream(file);
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,
          StandardCharsets.UTF_8);
      properties.load(inputStreamReader);
    } catch (IOException e) {
      System.err.println("Не найден обязательный файл настроек");
    }
    return properties;
  }

  public static String getProperty(final String key) {
    for (Properties properties : getInstance().propertiesList) {
      String result = properties.getProperty(key, null);
      if (result != null) {
        return result;
      }
    }
    return "";
  }
}
