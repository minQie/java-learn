package priv.wmc.study.thrid.lombok;

import org.junit.Test;

import lombok.Getter;
import lombok.Setter;

/** 
 * lombok代码生成规则
 * 
 * @author Wang Mincong
 * @date 2020-01-15 14:32
 */
public class GeneraterRegulation {

    @Test
    public void demo() {
        generateGetterAndSetter();
    }

    /**
     * get set 方法名生成规则
     *
     * 结论：对于boolean类型，lombok生成的“getter”是is开头的
     */
    public void generateGetterAndSetter() {
        Bean bean = new Bean();

        bean.getPrimitiveInt();
        bean.getPackageInt();

        bean.setPrimitiveInt(0);
        bean.setPackageInt(0);

        bean.isPrimitiveBoolean();
        bean.getPackageBoolean();
		
		bean.setPackageBoolean(true);
		bean.setPrimitiveBoolean(true);
	}

}

@Getter
@Setter
class Bean {
	
	private int primitiveInt;
	private Integer packageInt;
	
	private boolean primitiveBoolean;
	private Boolean packageBoolean;
	
}
