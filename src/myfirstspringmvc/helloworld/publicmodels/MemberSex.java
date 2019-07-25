package myfirstspringmvc.helloworld.publicmodels;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public enum MemberSex implements JSONSerializable {
    male() {
        @Override
        public void write(JSONSerializer jsonSerializer, Object o, Type type, int i) throws IOException {
            jsonSerializer.write(this.getStatus());
        }
    },

    female() {
        @Override
        public void write(JSONSerializer jsonSerializer, Object o, Type type, int i) throws IOException {
            jsonSerializer.write(this.getStatus());
        }
    },
    unknow() {
        @Override
        public void write(JSONSerializer jsonSerializer, Object o, Type type, int i) throws IOException {
            jsonSerializer.write(this.getStatus());
        }
    },;
    private int status;

    public int getStatus() {
        switch (this) {
            case male:return 1;
            case female:return 2;
            default:return 3;
        }
    }

    public static MemberSex sexOfValue(int value) {
        if (value == 1) {
            return male;
        } else if (value == 2) {
            return female;
        } else  {
            return unknow;
        }
    }
}

