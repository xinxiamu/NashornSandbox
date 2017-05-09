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
        
//        nashorn.eval("function a(){print('abc')}",simpleBindings);
//        nashorn.eval("a()",simpleBindings);

        nashorn.eval("load('src/eu/zeigermann/nashorn/databinding/dataAccess.js')", simpleBindings);
        Integer valueOut = (Integer) nashorn.eval("passGlobalValue()", simpleBindings);
        System.out.println(valueIn == valueOut.intValue());
        
        Integer integer = (Integer) nashorn.eval("passGlobalValue2()",simpleBindings);
        System.out.println("passGlobalValue2返回：" + integer);
        
//        nashorn.eval("load('src/eu/zeigermann/nashorn/databinding/dataAccess.js')");
//        User user2 = new User("zhang", 22);
//        String userName = (String) nashorn.eval("passGlobalValue3("+user2+")");
//        System.out.println("---userName:" + userName);
        
        //js返回对象
        System.out.println("-----js返回对象");
        nashorn.eval("load('src/eu/zeigermann/nashorn/databinding/dataAccess.js')",simpleBindings);
        User user = (User) nashorn.eval("passGlobalValue4()",simpleBindings);
        System.out.println("----user:" + user.getAge());
    }
    
}
