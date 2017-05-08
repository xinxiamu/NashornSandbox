package eu.zeigermann.nashorn.databinding;

import java.util.Date;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public class PassingData {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        int valueIn = 10;
        SimpleBindings simpleBindings = new SimpleBindings();
        simpleBindings.put("globalValue", valueIn);
        simpleBindings.put("user", new User("mu", 18,new Date(),"2017-05-06 06:09"));
        
        nashorn.eval("print (globalValue)", simpleBindings);
        nashorn.eval("print (user)", simpleBindings);

        nashorn.eval("load('src/eu/zeigermann/nashorn/databinding/dataAccess.js')", simpleBindings);
        Integer valueOut = (Integer) nashorn.eval("passGlobalValue()", simpleBindings);
        System.out.println(valueIn == valueOut.intValue());
        
//        User user = (User) nashorn.eval("passGlobalValue2()",simpleBindings);
//        System.out.println("----user:" + user.getAge());
        Integer integer = (Integer) nashorn.eval("passGlobalValue2()",simpleBindings);
        System.out.println("passGlobalValue2返回值：" + integer);
        
        //对象作为参数
//        nashorn.eval("load('src/eu/zeigermann/nashorn/databinding/dataAccess.js')");
//        User user2 = new User("zhang", 22);
//        String userName = (String) nashorn.eval("passGlobalValue3("+user2+")");
//        System.out.println("---userName:" + userName);
    }
    
}
