package com.example.aoppermission;

        import org.aspectj.lang.ProceedingJoinPoint;
        import org.aspectj.lang.annotation.Around;
        import org.aspectj.lang.annotation.Aspect;

/**
 * Created by yang2 on 2017/8/3.
 */
@Aspect
public class PermissionAspect {

    @Around("execution(@com.example.aoppermission.Permission * *(..)) && @annotation(permission)")
    public void aroundJoinPoint(final ProceedingJoinPoint joinPoint, final Permission permission) throws Throwable {
        PermissionUtil.requestPermissionsResult(MainActivity.mainActivity, 1, permission.value()
                , new PermissionUtil.OnPermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        try {
                            joinPoint.proceed();//获得权限，执行原方法
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onPermissionDenied() {
                        PermissionUtil.showTipsDialog(MainActivity.mainActivity);
                    }
                });
    }
}
