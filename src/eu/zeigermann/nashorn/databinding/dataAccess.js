function passGlobalValue () {
    return globalValue;
}

function passGlobalValue2() {
//	print(user);
//	var a = Java.type("eu.zeigermann.nashorn.databinding.User");  
//	a = user;	//user是绑定参数,赋值给a，a注意定义类型。
	var birthday = user.birthday;
	print(birthday);
	print(birthday.getMinutes());
	print("userName:" + user.name);  
	
	print(user.birthday2);
	var birthday2 = new Date(user.birthday2);
	print(birthday2);
	print(birthday2.getFullYear() + "年");
	print(birthday2.getMonth() + 1 + "月");
	print(birthday2.getDay() + "日");
	print(birthday2.getHours() + "时");
	print(birthday2.getMinutes() + "分");
	print(birthday2.getSeconds() + "秒");
	return 5;
}

function passGlobalValue3(user) {
//	print(user);
	return "abc";
}
