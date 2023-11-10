# Volatile Keyword

Various sample programs

### Difference between `volatile` and `synchronized` 

So, where volatile only synchronizes the value of one variable between the thread memory and the "main" memory, synchronized synchronizes the value of all variables between the thread memory and the "main" memory and locks and releases a monitor to control the ownership between multiple threads.
From this information, it can be concluded that synchronized is likely to have more overhead than volatile.
