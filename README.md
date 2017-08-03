#发现网上有很多权限请求框架，所以我自己也来写一个aop的请求框架，好处是不入侵原有代码达到解耦的效果。

使用方法

```
 @Permission({Manifest.permission.READ_EXTERNAL_STORAGE})
    public void onClick(View v){
        Toast.makeText(this,"切面成功",Toast.LENGTH_LONG).show();
    }
```
