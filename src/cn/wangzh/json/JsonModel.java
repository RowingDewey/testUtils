package cn.wangzh.json;

import java.util.List;

public class JsonModel
{
    private List<BaseModel> modelList;
    
    public List<BaseModel> getModelList()
    {
        return modelList;
    }
    
    public void setModelList(List<BaseModel> modelList)
    {
        this.modelList = modelList;
    }
    
    @Override
    public String toString()
    {
        return "JsonModel [modelList=" + modelList + "]";
    }
}
