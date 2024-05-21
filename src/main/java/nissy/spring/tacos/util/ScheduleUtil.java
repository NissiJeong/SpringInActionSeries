package nissy.spring.tacos.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleUtil {

    private static final Logger log = LoggerFactory.getLogger(ScheduleUtil.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)//milliseconds 단위로, 이전 Task의 시작 시점으로부터 정의된 시간만큼 지난 후 Task를 실행
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));
	}

    @Scheduled(cron = "0 0 0 * * *") //매일 자정에 해당 메소드 실행
    public void cronExample(){
        log.info("This Example is cron expressions. The time is now {}", dateFormat.format(new Date()));
    }
}
