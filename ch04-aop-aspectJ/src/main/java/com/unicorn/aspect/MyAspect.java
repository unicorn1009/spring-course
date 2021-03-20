package com.unicorn.aspect;

import com.unicorn.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * </p>
 * Created on 2021/3/15 0015
 *
 * @author Unicorn
 */
@Aspect // aspectJ 的注解, 表示当前类是切面类, 是给业务方法增加功能的类
@Component  // 还需要添加注解给spring容器管理
public class MyAspect {

    // @Before在目标方法之前执行, value属性是切入点表达式, 表示切面的功能执行的位置
    // 可以给切面函数(即增加功能的函数)添加JoinPoint参数(连接点函数), aspectJ会在执行目标函数时, 将目标函数具体信息传入该参数中
    // JoinPoint参数必须是放在第一个参数位置
    @Before(value = "execution(public void com.unicorn.service.impl.TeacherServiceImpl.teach(String))")
    public void myBefore(JoinPoint joinPoint){
        System.out.println("函数签名: " + joinPoint.getSignature());      // 获取函数签名
        System.out.println("目标函数名: " + joinPoint.getSignature().getName());      // 获取函数名

        // 获取目标函数的参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("参数 == " + arg);
        }

        System.out.println("切面方法 : 前置通知 : 在目标方法之前执行 : "+ new Date());
    }

    /**
     * 后置通知 @AfterReturning
     * 属性: 1. value 切入点表达式
     *      2. returning 自定义变量, 用于接收目标函数返回值, 会自动传入切面方法, 需要与函数参数变量名一致
     *          相当于 Object res = teach(a, b)
     */
    @AfterReturning(value = "execution(public String com.unicorn.service.impl.TeacherServiceImpl.sayHello(String))",
    returning = "res")
    public void myAfterReturning(Object res){
        System.out.println("切面方法 : 后置通知 : 在目标方法之后执行 : "+ new Date());
        System.out.println("目标函数返回值为 : " + res);
        res = ((String) res) + "====";
    }

    // JoinPoint参数必须是放在第一个参数位置
    @AfterReturning(value = "execution(public * com.unicorn.service.impl.TeacherServiceImpl.getStudent(String))",
            returning = "res")
    public void myAfterReturning1(JoinPoint joinPoint, Object res){
        System.out.println("传入目标函数的参数为 : "+joinPoint.getArgs()[0]);
        System.out.println("切面方法 : 后置通知 : 在目标方法之后执行 : "+ new Date());
        System.out.println("修改前===目标函数返回值为 : " + res);
        ((Student) res).setName("我的名字被代理修改了!");
    }




    /**
     * 环绕通知 @AfterReturning  功能最强的通知, 可在目标方法前后都增强
     * 1. public
     * 2. 必须有返回值, 建议Object, 返回给调用者
     * 3. 方法有固定参数 : proceedingJoinPoint 等同于动态代理中的Method
     * 4. ProceedingJoinPoint 继承自 JoinPoint, 因此可用它直接获取目标函数信息
     * 5. 属性 :
     *      value 切入点表达式
     */

    @Around(value = "execution(* com.unicorn.service.impl.TeacherServiceImpl.sayHello(String))")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        System.out.println("环绕通知, 目标方法执行前...");
        System.out.println("环绕通知中使用ProceedingJoinPoint获取目标函数信息 : "+proceedingJoinPoint.getSignature());
        result = proceedingJoinPoint.proceed();  // 等同于Method.invoke()
        System.out.println("环绕通知, 目标方法执行后...");
        return result;
    }
}
