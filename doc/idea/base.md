##### 打印的快捷提示方式

sout: Prints

> System.out.println();

soutm: Prints current class and method names to System.out

> System.out.println($CLASS_NAME$.$METHOD_NAME$);

soutp: Prints method parameter names and values to System.out

> System.out.println($FORMAT$);
 
soutv: Prints a value

> System.out.println("$EXPR_COPY = $ " + $EXPR$);

souf: Print a format

>System.out.printf()


##### printf 颜色

###### 一、格式

\033[显示方式;前景色；背景色m

1） 显示方式： 0 默认值 1 高亮 22 非粗体 4 下划线 24 非下划线 5 闪缩 25 非闪缩 7 反显 27 非反显
2） 30 黑色 31 红色 32 绿色 33 黄色 34 蓝色 35 杨红 36 青色 37 白色
4） 40 黑色 41 红色 42 绿色 43 黄色 44 蓝色 45 杨红 46 青色 47 白色

###### 二、例子

1) 默认颜色： \033[0m
2) 绿色： \033[0;32m
3) 红色： \033[0;31m
