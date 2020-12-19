package com.bloomberg.clustereddata.domain.xtras;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public enum AppUtil {


    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUtil.class);

    AppUtil() {

    }

    static byte[] concatenateByteArrays(List<byte[]> blocks) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        for (byte[] b : blocks) {
            os.write(b, 0, b.length);
        }
        return os.toByteArray();
    }

    public <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public final boolean stringIsNullOrEmpty(String arg) {
        if ((arg == null)) return true;
        else
            return ("".equals(arg)) || (arg.trim().length() == 0);
    }



}
