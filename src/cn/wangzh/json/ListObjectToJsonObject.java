package cn.wangzh.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListObjectToJsonObject
{
    public static void main(String[] args) {
        BaseModel baseModel1 = new BaseModel();
        baseModel1.setAge("10");
        baseModel1.setName("10");
        baseModel1.setPassword("10");
        
        BaseModel baseModel2 = new BaseModel();
        baseModel2.setAge("11");
        baseModel2.setName("11");
        baseModel2.setPassword("11");
        
        BaseModel baseModel3 = new BaseModel();
        baseModel3.setAge("12");
        baseModel3.setName("12");
        baseModel3.setPassword("12");
        
        BaseModel baseModel4 = new BaseModel();
        baseModel4.setAge("13");
        baseModel4.setName("13");
        // baseModel4.setPassword("13");
        
        JsonModel jsonModel = new JsonModel();
        List<BaseModel> list = new ArrayList<BaseModel>();
        jsonModel.setModelList(list);
        list.add(baseModel1);
        list.add(baseModel2);
        list.add(baseModel3);
        list.add(baseModel4);
        
        /*
         * JSONObject jsonObj = (JSONObject)JSONObject.toJSON(jsonModel); StringBuilder str = new StringBuilder();
         * str.append("{"); str.append("\"Request\":"); str.append(jsonObj.toString()); //
         * str.append("\"").append(jsonObj.toString()).append("\""); str.append("}");
         */
        
        System.out.println(objectToJsonString(jsonModel, "addUserBookMarkRsp"));
        System.out.println(objectToJsonString(null, "addUserBookMarkRsp"));
        System.out.println();
        System.out.println(JSONObject.toJSONString(jsonModel,
            new SerializerFeature[] {SerializerFeature.PrettyFormat, SerializerFeature.WriteClassName,
                SerializerFeature.WriteNullStringAsEmpty}));
        
        String json =
            "{\"modelList\":[{\"password\":\"10\",\"name\":\"10\",\"age\":\"10\"},{\"password\":\"11\",\"name\":\"11\",\"age\":\"11\"}]}\"";
        
        System.out.println(jsonToObject(json, JsonModel.class));
        
    }
    
    static public String objectToJsonString(Object obj, String boot) {
        
        JSONObject jsonObj = (JSONObject)JSONObject.toJSON(obj);
        StringBuilder str = new StringBuilder();
        str.append("{");
        str.append("\"Request\":{" + "\"" + boot + "\":");
        if (null != jsonObj)
        {
            str.append(jsonObj.toString());
        }
        else
        {
            str.append("\"\"");
        }
        
        // str.append("\"").append(jsonObj.toString()).append("\"");
        str.append("}}");
        
        // System.out.println(str.toString());
        
        return str.toString();
    }
    
    static public String jsonToObject(String obj, Class claszz) {
        
        JSONObject jsonObj = (JSONObject)JSONObject.parseObject(obj);
        System.out.println(jsonObj);
        @SuppressWarnings("unchecked")
        JsonModel jsonmodel = JSONObject.parseObject(obj, (Type)claszz);
        
        return jsonmodel.toString();
    }
}
