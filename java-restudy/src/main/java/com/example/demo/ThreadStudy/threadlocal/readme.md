ThreadLocal JDK1.8之后 

为每个线程单独创建一个ThreadLocalMap
其键为弱引用

## 注意

ThreadLocal 若使用不当会造成内存泄漏

## 原因
1.ThreadLocal生命周期和Thread是一样长，特别是使用线程池，ThreadLocal不是去释放Map

解释：线程池中的线程在任务执行完成后会被复用，所以在线程执行完成时，要对 ThreadLocal 进行清理（清除掉与本线程相关联的 value 对象）。不然，被复用的线程去执行新的任务时会使用被上一个线程操作过的 value 对象，从而产生不符合预期的结果。

2.ThreadLocalMap中的Entry，其键由于弱引用使用完会被释放，设置为null，但是其值不会释放，会一直保存早Map中(这里内存泄漏与使用强引用弱引用无关，使用弱引用会更好，因为下次ThreadLocalMap在调用set、get等方法时会将key为null的entry的value也设置为null，此时就会被清除)

## 如何避免
1.使用完ThreadLocal手动调用remove去删除Entry
2.使用完ThreadLocal后Thread也随之销毁
