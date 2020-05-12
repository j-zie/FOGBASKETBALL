package FunctionLayer;

import DBAccess.UserMapper;

import java.util.ArrayList;

public class LavSelectFormHTML {

    public String fåSelectForm() throws LoginSampleException {
        ArrayList<User> arrayList = UserMapper.getAllUsers();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<div class=\"input-field col s12\">\n" +
                "    <select name =\"id\">\n" +
                "      <option value=\"\" disabled selected>Choose your option</option\n");

        for (int i = 0; i < arrayList.size(); i++) {
            String tempStreng = arrayList.subList(0, arrayList.size()).get(i).toString();
            String udtaget1 = tempStreng.substring(tempStreng.indexOf("id="),tempStreng.lastIndexOf(", p"));
            String udtaget2 = tempStreng.substring(tempStreng.indexOf("navn="),tempStreng.lastIndexOf(", a"));
            String kunID = udtaget1.substring(3);
        stringBuilder.append("<option value=\""+kunID+"\">"+kunID+ " " + udtaget2+"</option>\n");
        }

        stringBuilder.append(" </select>\n" +
                "    <label>Materialize Select</label>\n" +
                "  </div>");
        return stringBuilder.toString();
    }


};
