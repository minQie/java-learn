package priv.wmc.study.thrid.lombok;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wang Mincong
 * @date 2019-08-19 15:02
 */
@Slf4j
public class Demo {

    public static void main(String[] args) {
//        noArgsConstructorDemo();
//        requiredArgsConstructorDemo();
//        ofDemo();
    }

    public static void noArgsConstructorDemo() {
        NoArgsConstructorDemo demo = new NoArgsConstructorDemo();
        log.info(demo.getString());
        log.info(String.valueOf(demo.isBool()));
        log.info(String.valueOf(demo.getInteger()));
    }

	public static void requiredArgsConstructorDemo() {
		new RequiredArgsConstructorDemo("", null, null);
	}
	
	public static void ofDemo() {
//		new AllArgsConstructorDemo("1");
		@SuppressWarnings("unused")
		AllArgsConstructorDemo demo = AllArgsConstructorDemo.of("1");
	}
	
	public static void ofGenericDemo() {
		// 使用了staticName或者staticConstructor属性，可以使用如下方式替代new方式的写法
		// new DataAnnotationDemo<Integer>(1);
		DataAnnotationDemo.of(1);
	}

}
