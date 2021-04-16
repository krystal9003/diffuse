//package com.han.diffuse.serialize.hessian;
//
//import com.han.diffuse.serialize.DiffuseSerialize;
//import com.sun.xml.internal.ws.encoding.soap.SerializationException;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//
//@Slf4j
//public class HessianSerialization implements DiffuseSerialize {
//    @Override
//    public <T> byte[] serialize(T object) {
//        if (object == null) {
//            throw new NullPointerException();
//        }
//        byte[] results;
//        HessianSerializerOutput hessianOutput;
//        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
//            hessianOutput = new HessianSerializerOutput(os);
//            hessianOutput.writeObject(object);
//            hessianOutput.flush();
//            results = os.toByteArray();
//        } catch (Exception e) {
//            throw new SerializationException(e);
//        }
//        return results;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public <T> T deserialize(byte[] bytes, Class<T> clz) {
//        if (bytes == null) {
//            throw new NullPointerException();
//        }
//        T result;
//        try (ByteArrayInputStream is = new ByteArrayInputStream(bytes)) {
//            HessianSerializerInput hessianInput = new HessianSerializerInput(is);
//            result = (T) hessianInput.readObject(clz);
//        } catch (Exception e) {
//            throw new SerializationException(e);
//        }
//        return result;
//    }
//}