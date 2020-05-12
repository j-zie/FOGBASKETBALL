package FunctionLayer;

import DBAccess.MaterialeMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;

public class LavSelectFormHTML {

    public String fåSelectFormForBrugerepåID() throws LoginSampleException {
        ArrayList<User> arrayList = UserMapper.getAllUsers();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<div class=\"input-field col s12\" id=\"dropper\">\n" +
                "    <select name =\"id\">\n" +
                "      <option value=\"\" disabled selected>Vælg id</option\n");

        for (int i = 0; i < arrayList.size(); i++) {
            String tempStreng = arrayList.subList(0, arrayList.size()).get(i).toString();
            String udtaget1 = tempStreng.substring(tempStreng.indexOf("id="),tempStreng.lastIndexOf(", password"));
            String udtaget2 = tempStreng.substring(tempStreng.indexOf("navn="),tempStreng.lastIndexOf(", adresse"));
            String udtaget3 = tempStreng.substring(tempStreng.indexOf("telefon="),tempStreng.lastIndexOf(", email"));
            String kunID = udtaget1.substring(3);
            stringBuilder.append("<option value=\""+kunID+"\">"+udtaget1+ " " + udtaget2 + " " + udtaget3 +"</option>\n");
        }

        stringBuilder.append(" </select>\n" +
                "  </div>");
        return stringBuilder.toString();
    }

    public String fåSelectFormForMaterialerpåID() throws LoginSampleException {
        ArrayList<Materiale> arrayList = MaterialeMapper.getAlleMaterialer();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<div class=\"input-field col s12\" id=\"dropper\">\n" +
                "    <select name =\"id\">\n" +
                "      <option value=\"\" disabled selected>Vælg MaterialeId</option\n");

        for (int i = 0; i < arrayList.size(); i++) {
            String tempStreng = arrayList.subList(0, arrayList.size()).get(i).toString();
            String udtaget1 = tempStreng.substring(tempStreng.indexOf("materialeID="),tempStreng.lastIndexOf(", materialeNavn"));
            String udtaget2 = tempStreng.substring(tempStreng.indexOf("materialeNavn="),tempStreng.lastIndexOf(", pris"));
            String udtaget3 = tempStreng.substring(tempStreng.indexOf("pris="),tempStreng.lastIndexOf("}"));
            String kunID = udtaget1.substring(12);
            stringBuilder.append("<option value=\""+kunID+"\">"+udtaget1+ " " + udtaget2 + " " + udtaget3 +"</option>\n");
        }

        stringBuilder.append(" </select>\n" +
                "  </div>");
        return stringBuilder.toString();
    }


};
