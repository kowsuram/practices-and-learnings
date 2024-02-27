package io.kowsu.dp.structural;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DecoratorPattern {

    public static void main(String[] args) {
        System.out.println("@@@@@@@@@@@@ Fetching current day info @@@@@@@@@@@@");
        IWeatherInfo weatherInfo = new BasicWeatherInfo();
        System.out.println(weatherInfo.getWeatherInfo());

        System.out.println("@@@@@@@@@@@@ Fetching 7 days info @@@@@@@@@@@@");
        IWeatherInfo days_7Info = new NextWeekWeatherInfoDecorator(weatherInfo);
        System.out.println(days_7Info.getWeatherInfo());
        System.out.println("@@@@@@@@@@@@ Fetching 15 days info @@@@@@@@@@@@");
        IWeatherInfo days_15Info = new Next15DaysWeatherInfoDecorator(weatherInfo);
        System.out.println(days_15Info.getWeatherInfo());
    }

}

record Weather(String temperature, String humidity, String wind) {
}

interface IWeatherInfo {
    Map<LocalDate, Weather> getWeatherInfo();
}

class BasicWeatherInfo implements IWeatherInfo {
    @Override
    public Map<LocalDate, Weather> getWeatherInfo() {
        return Map.of(LocalDate.now(), new Weather("23.1F", "12", "11kmph"));
    }
}

abstract class BaseWeatherDecorator implements IWeatherInfo {
    protected IWeatherInfo weatherInfo;

    public BaseWeatherDecorator(IWeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    @Override
    public Map<LocalDate, Weather> getWeatherInfo() {
        return fetchFromExternalSource();
    }

    abstract Map<LocalDate, Weather> fetchFromExternalSource();

}

class NextWeekWeatherInfoDecorator extends BaseWeatherDecorator {


    public NextWeekWeatherInfoDecorator(IWeatherInfo weatherInfo) {
        super(weatherInfo);
    }

    @Override
    Map<LocalDate, Weather> fetchFromExternalSource() {
        return call7DaysService();
    }

    private Map<LocalDate, Weather> call7DaysService() {
        return Map.of(
                LocalDate.now(), new Weather("23.1F", "12", "11kmph"),
                LocalDate.now().plusDays(1), new Weather("23.1F", "12", "11kmph"),
                LocalDate.now().plusDays(2), new Weather("22.1F", "12", "11kmph"),
                LocalDate.now().plusDays(3), new Weather("21.1F", "12", "11kmph"),
                LocalDate.now().plusDays(4), new Weather("20.1F", "12", "11kmph"),
                LocalDate.now().plusDays(5), new Weather("19.1F", "12", "11kmph"),
                LocalDate.now().plusDays(6), new Weather("18.1F", "12", "11kmph")
        );
    }

}


class Next15DaysWeatherInfoDecorator extends BaseWeatherDecorator {


    public Next15DaysWeatherInfoDecorator(IWeatherInfo weatherInfo) {
        super(weatherInfo);
    }

    @Override
    Map<LocalDate, Weather> fetchFromExternalSource() {
        return call15DaysService();
    }

    private Map<LocalDate, Weather> call15DaysService() {

        Map<LocalDate, Weather> weatherInfo = new HashMap<>(
                Map.of(
                        LocalDate.now(), new Weather("23.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(1), new Weather("23.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(2), new Weather("22.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(3), new Weather("21.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(4), new Weather("20.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(5), new Weather("19.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(6), new Weather("18.1F", "12", "11kmph")
                )
        );

        Map<LocalDate, Weather> weatherInfo1 =
                Map.of(
                        LocalDate.now(), new Weather("23.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(7), new Weather("23.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(8), new Weather("22.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(9), new Weather("21.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(10), new Weather("20.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(11), new Weather("19.1F", "12", "11kmph"),
                        LocalDate.now().plusDays(12), new Weather("18.1F", "12", "11kmph")
                );
        weatherInfo.putAll(weatherInfo1);
        return weatherInfo;
    }

}
