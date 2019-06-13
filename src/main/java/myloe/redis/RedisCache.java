package myloe.redis;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: mybatis-spring
 * @description: redis缓存类 实现mybatis的Cahce接口
 * @author: Mr.Loe
 * @create: 2019-06-11 11:45
 **/
public class RedisCache implements Cache {
    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);


    private static RedisTemplate redisTemplate;

    private final String id;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug("MybatisRedisCache:id=" + id);
        this.id = id;
    }

    public static void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.redisTemplate = redisTemplate;
    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            logger.debug(">>>>>>>>>>>>>>>>>>存入缓存数据,key:"+key+",value="+value);

            if(null!=value){
                redisTemplate.opsForValue().set(key.toString(),value,2, TimeUnit.DAYS);
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error("存入数据发生异常："+e.getMessage());
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public Object getObject(Object key) {
        readWriteLock.readLock().lock();
        try {
            logger.debug(">>>>>>>>>>>>>>>>>>读取缓存数据,key:"+key);

//            System.out.println(">>>>>>>>>>>>>>>>>>读取缓存数据,key:"+key);
            if(null!=key){
                return redisTemplate.opsForValue().get(key.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("读取缓存数据发生异常："+e.getMessage());
        }finally {
            readWriteLock.readLock().unlock();
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        readWriteLock.writeLock().lock();

        try {
            logger.debug(">>>>>>>>>>>>>>>>>>删除缓存数据,key:"+key);

            if(null!=key){
                return redisTemplate.expire(key,1,TimeUnit.DAYS);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除缓存数据发生异常："+e.getMessage());
        }finally {
            readWriteLock.writeLock().unlock();
        }

        return null;
    }

    /**
     * 这个一般不实现，就算实现了，也不要清所有数据，否则之前的缓存都不在了。
     */
    @Override
    public void clear() {
       /* Object size=redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                Object size=redisConnection.dbSize();
                redisConnection.flushDb();
                redisConnection.flushAll();
                return size;
            }
        });

        logger.info(">>>>>>>>>>>>>>> clear: 清除了"+size+"个缓存对象");*/
    }

    @Override
    public int getSize() {

        Object size=redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.dbSize();
            }
        });
        return (int) size;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
