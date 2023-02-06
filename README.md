### Narayana + DBCP2
If poolPreparedStatements is set to true and a transaction times out, the application throws a stackoverflow error when executing the next preparedStatement

`
2023-02-06 19:19:31.380 ERROR 66997 --- [o-auto-1-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Handler dispatch failed; nested exception is java.lang.StackOverflowError] with root cause

java.lang.StackOverflowError: null
at java.base/java.lang.StringBuilder.<init>(StringBuilder.java:103) ~[na:na]
at java.base/java.lang.Object.toString(Object.java:246) ~[na:na]
at java.base/java.lang.String.valueOf(String.java:2951) ~[na:na]
at java.base/java.lang.StringBuilder.append(StringBuilder.java:172) ~[na:na]
at org.apache.commons.pool2.impl.BaseGenericObjectPool.toStringAppendFields(BaseGenericObjectPool.java:1400) ~[commons-pool2-2.9.0.jar:2.9.0]
at org.apache.commons.pool2.impl.GenericKeyedObjectPool.toStringAppendFields(GenericKeyedObjectPool.java:1626) ~[commons-pool2-2.9.0.jar:2.9.0]
at java.base/java.lang.String.valueOf(String.java:2951) ~[na:na]
at java.base/java.lang.StringBuilder.append(StringBuilder.java:172) ~[na:na]
at org.apache.commons.pool2.impl.GenericKeyedObjectPool.toStringAppendFields(GenericKeyedObjectPool.java:1634) ~[commons-pool2-2.9.0.jar:2.9.0]
at org.apache.commons.pool2.BaseObject.toString(BaseObject.java:31) ~[commons-pool2-2.9.0.jar:2.9.0]
at org.apache.commons.dbcp2.PoolingConnection.toString(PoolingConnection.java:606) ~[commons-dbcp2-2.8.0.jar:2.8.0]
at java.base/java.lang.String.valueOf(String.java:2951) ~[na:na]
at java.base/java.lang.StringBuilder.append(StringBuilder.java:172) ~[na:na]
at org.apache.commons.pool2.impl.GenericKeyedObjectPool.toStringAppendFields(GenericKeyedObjectPool.java:1634) ~[commons-pool2-2.9.0.jar:2.9.0]
at org.apache.commons.pool2.BaseObject.toString(BaseObject.java:31) ~[commons-pool2-2.9.0.jar:2.9.0]
at org.apache.commons.dbcp2.PoolingConnection.toString(PoolingConnection.java:606) ~[commons-dbcp2-2.8.0.jar:2.8.0]
at org.apache.commons.dbcp2.DelegatingConnection.checkOpen(DelegatingConnection.java:599) ~[commons-dbcp2-2.8.0.jar:2.8.0]
at org.apache.commons.dbcp2.DelegatingConnection.prepareStatement(DelegatingConnection.java:298) ~[commons-dbcp2-2.8.0.jar:2.8.0]
at org.apache.commons.dbcp2.DelegatingConnection.prepareStatement(DelegatingConnection.java:301) ~[commons-dbcp2-2.8.0.jar:2.8.0]
at org.test.DBController.insertOperation(DBController.java:37) ~[classes/:na]
`

### To reproduce the issue

- `mvn test`