Collection<br>
接口是Set,Queue,List的父接口。Collection接口中定义了多种方法可供其子类进行实现，以实现数据操作。<br>
![Collection接口的相关方法](https://upload-images.jianshu.io/upload_images/13458543-f3f01e2714609114.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)<br>
注意：<br>
1,equals()比较的是两个值是不是相等，而一般的==比较的是地址<br>
2,当使用Iterator对集合元素进行迭代时，Iterator并不是把集合元素本身传给了迭代变量，而是把集合元素的值传给了迭代变量（就如同参数传递是值传递，基本数据类型传递的是值，引用类型传递的仅仅是对象的引用变量），所以修改迭代变量的值对集合元素本身没有任何影响。<br>
3,clear()是将集合里面的所有元素都清空，而removeAll参数是集合，在该元素里面包含集合的元素清空。<br>


