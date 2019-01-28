//: net/mindview/util/Countries.java
// "Flyweight" Maps and Lists of sample data.
package net.mindview.util;
import java.util.*;
import static net.mindview.util.Print.*;

/**
* @Description: 重点，难理解
* @Author:hxw
* @Date:2019/1/27 20:39
*/
public class Countries {
    public static final String[][] DATA = {
            // Africa
            {"ALGERIA","Algiers"}, {"ANGOLA","Luanda"},
            {"BENIN","Porto-Novo"}, {"BOTSWANA","Gaberone"},
            {"BURKINA FASO","Ouagadougou"},
            {"BURUNDI","Bujumbura"},
            {"CAMEROON","Yaounde"}, {"CAPE VERDE","Praia"},
            {"CENTRAL AFRICAN REPUBLIC","Bangui"},
            {"CHAD","N'djamena"},  {"COMOROS","Moroni"},
            {"CONGO","Brazzaville"}, {"DJIBOUTI","Dijibouti"},
            {"EGYPT","Cairo"}, {"EQUATORIAL GUINEA","Malabo"},
            {"ERITREA","Asmara"}, {"ETHIOPIA","Addis Ababa"},
            {"GABON","Libreville"}, {"THE GAMBIA","Banjul"},
            {"GHANA","Accra"}, {"GUINEA","Conakry"},
            {"BISSAU","Bissau"},
            {"COTE D'IVOIR (IVORY COAST)","Yamoussoukro"},
            {"KENYA","Nairobi"}, {"LESOTHO","Maseru"},
            {"LIBERIA","Monrovia"}, {"LIBYA","Tripoli"},
            {"MADAGASCAR","Antananarivo"}, {"MALAWI","Lilongwe"},
            {"MALI","Bamako"}, {"MAURITANIA","Nouakchott"},
            {"MAURITIUS","Port Louis"}, {"MOROCCO","Rabat"},
            {"MOZAMBIQUE","Maputo"}, {"NAMIBIA","Windhoek"},
            {"NIGER","Niamey"}, {"NIGERIA","Abuja"},
            {"RWANDA","Kigali"},
            {"SAO TOME E PRINCIPE","Sao Tome"},
            {"SENEGAL","Dakar"}, {"SEYCHELLES","Victoria"},
            {"SIERRA LEONE","Freetown"}, {"SOMALIA","Mogadishu"},
            {"SOUTH AFRICA","Pretoria/Cape Town"},
            {"SUDAN","Khartoum"},
            {"SWAZILAND","Mbabane"}, {"TANZANIA","Dodoma"},
            {"TOGO","Lome"}, {"TUNISIA","Tunis"},
            {"UGANDA","Kampala"},
            {"DEMOCRATIC REPUBLIC OF THE CONGO (ZAIRE)", "Kinshasa"},
            {"ZAMBIA","Lusaka"}, {"ZIMBABWE","Harare"},
            // Asia
            {"AFGHANISTAN","Kabul"}, {"BAHRAIN","Manama"},
            {"BANGLADESH","Dhaka"}, {"BHUTAN","Thimphu"},
            {"BRUNEI","Bandar Seri Begawan"},
            {"CAMBODIA","Phnom Penh"},
            {"CHINA","Beijing"}, {"CYPRUS","Nicosia"},
            {"INDIA","New Delhi"}, {"INDONESIA","Jakarta"},
            {"IRAN","Tehran"}, {"IRAQ","Baghdad"},
            {"ISRAEL","Jerusalem"}, {"JAPAN","Tokyo"},
            {"JORDAN","Amman"}, {"KUWAIT","Kuwait City"},
            {"LAOS","Vientiane"}, {"LEBANON","Beirut"},
            {"MALAYSIA","Kuala Lumpur"}, {"THE MALDIVES","Male"},
            {"MONGOLIA","Ulan Bator"},
            {"MYANMAR (BURMA)","Rangoon"},
            {"NEPAL","Katmandu"}, {"NORTH KOREA","P'yongyang"},
            {"OMAN","Muscat"}, {"PAKISTAN","Islamabad"},
            {"PHILIPPINES","Manila"}, {"QATAR","Doha"},
            {"SAUDI ARABIA","Riyadh"}, {"SINGAPORE","Singapore"},
            {"SOUTH KOREA","Seoul"}, {"SRI LANKA","Colombo"},
            {"SYRIA","Damascus"},
            {"TAIWAN (REPUBLIC OF CHINA)","Taipei"},
            {"THAILAND","Bangkok"}, {"TURKEY","Ankara"},
            {"UNITED ARAB EMIRATES","Abu Dhabi"},
            {"VIETNAM","Hanoi"}, {"YEMEN","Sana'a"},
            // Australia and Oceania
            {"AUSTRALIA","Canberra"}, {"FIJI","Suva"},
            {"KIRIBATI","Bairiki"},
            {"MARSHALL ISLANDS","Dalap-Uliga-Darrit"},
            {"MICRONESIA","Palikir"}, {"NAURU","Yaren"},
            {"NEW ZEALAND","Wellington"}, {"PALAU","Koror"},
            {"PAPUA NEW GUINEA","Port Moresby"},
            {"SOLOMON ISLANDS","Honaira"}, {"TONGA","Nuku'alofa"},
            {"TUVALU","Fongafale"}, {"VANUATU","< Port-Vila"},
            {"WESTERN SAMOA","Apia"},
            // Eastern Europe and former USSR
            {"ARMENIA","Yerevan"}, {"AZERBAIJAN","Baku"},
            {"BELARUS (BYELORUSSIA)","Minsk"},
            {"BULGARIA","Sofia"}, {"GEORGIA","Tbilisi"},
            {"KAZAKSTAN","Almaty"}, {"KYRGYZSTAN","Alma-Ata"},
            {"MOLDOVA","Chisinau"}, {"RUSSIA","Moscow"},
            {"TAJIKISTAN","Dushanbe"}, {"TURKMENISTAN","Ashkabad"},
            {"UKRAINE","Kyiv"}, {"UZBEKISTAN","Tashkent"},
            // Europe
            {"ALBANIA","Tirana"}, {"ANDORRA","Andorra la Vella"},
            {"AUSTRIA","Vienna"}, {"BELGIUM","Brussels"},
            {"BOSNIA","-"}, {"HERZEGOVINA","Sarajevo"},
            {"CROATIA","Zagreb"}, {"CZECH REPUBLIC","Prague"},
            {"DENMARK","Copenhagen"}, {"ESTONIA","Tallinn"},
            {"FINLAND","Helsinki"}, {"FRANCE","Paris"},
            {"GERMANY","Berlin"}, {"GREECE","Athens"},
            {"HUNGARY","Budapest"}, {"ICELAND","Reykjavik"},
            {"IRELAND","Dublin"}, {"ITALY","Rome"},
            {"LATVIA","Riga"}, {"LIECHTENSTEIN","Vaduz"},
            {"LITHUANIA","Vilnius"}, {"LUXEMBOURG","Luxembourg"},
            {"MACEDONIA","Skopje"}, {"MALTA","Valletta"},
            {"MONACO","Monaco"}, {"MONTENEGRO","Podgorica"},
            {"THE NETHERLANDS","Amsterdam"}, {"NORWAY","Oslo"},
            {"POLAND","Warsaw"}, {"PORTUGAL","Lisbon"},
            {"ROMANIA","Bucharest"}, {"SAN MARINO","San Marino"},
            {"SERBIA","Belgrade"}, {"SLOVAKIA","Bratislava"},
            {"SLOVENIA","Ljuijana"}, {"SPAIN","Madrid"},
            {"SWEDEN","Stockholm"}, {"SWITZERLAND","Berne"},
            {"UNITED KINGDOM","London"}, {"VATICAN CITY","---"},
            // North and Central America
            {"ANTIGUA AND BARBUDA","Saint John's"},
            {"BAHAMAS","Nassau"},
            {"BARBADOS","Bridgetown"}, {"BELIZE","Belmopan"},
            {"CANADA","Ottawa"}, {"COSTA RICA","San Jose"},
            {"CUBA","Havana"}, {"DOMINICA","Roseau"},
            {"DOMINICAN REPUBLIC","Santo Domingo"},
            {"EL SALVADOR","San Salvador"},
            {"GRENADA","Saint George's"},
            {"GUATEMALA","Guatemala City"},
            {"HAITI","Port-au-Prince"},
            {"HONDURAS","Tegucigalpa"}, {"JAMAICA","Kingston"},
            {"MEXICO","Mexico City"}, {"NICARAGUA","Managua"},
            {"PANAMA","Panama City"}, {"ST. KITTS","-"},
            {"NEVIS","Basseterre"}, {"ST. LUCIA","Castries"},
            {"ST. VINCENT AND THE GRENADINES","Kingstown"},
            {"UNITED STATES OF AMERICA","Washington, D.C."},
            // South America
            {"ARGENTINA","Buenos Aires"},
            {"BOLIVIA","Sucre (legal)/La Paz(administrative)"},
            {"BRAZIL","Brasilia"}, {"CHILE","Santiago"},
            {"COLOMBIA","Bogota"}, {"ECUADOR","Quito"},
            {"GUYANA","Georgetown"}, {"PARAGUAY","Asuncion"},
            {"PERU","Lima"}, {"SURINAME","Paramaribo"},
            {"TRINIDAD AND TOBAGO","Port of Spain"},
            {"URUGUAY","Montevideo"}, {"VENEZUELA","Caracas"},
    };
    // Use AbstractMap by implementing entrySet() 使用AbstractMap必须实现entrySet()方法
    private static class FlyweightMap extends AbstractMap<String,String> {

        /**
         * 目的：自定义Entry
         * FlyweightMap的私有静态内部类Entry实现了Map.Entry接口，作为自定义映射 (必须实现getKey()、getValue()和 setValue(V value)方法)
         */
        private static class Entry implements Map.Entry<String,String> {
            int index;
            Entry(int index) { this.index = index; } //初始化index

            public boolean equals(Object o) {
                return DATA[index][0].equals(o); //判断Entry相等的条件是二维数组DATA中国家是否一样
            }

            public String getKey() {
                return DATA[index][0]; //key是国家
            }

            public String getValue() {
                return DATA[index][1]; //value是首都
            }

            public String setValue(String value) { //不能写入
                throw new UnsupportedOperationException();
            }
            public int hashCode() {
                return DATA[index][0].hashCode(); //国家字符串的hash
            }

        }

        /**
         * FlyweightMap的静态内部类EntrySet继承AbstractSet
         */
        // Use AbstractSet by implementing size() & iterator()
        static class EntrySet extends AbstractSet<Map.Entry<String,String>> {
            private int size; //EntrySet中元素个数
            EntrySet(int size) {  //EntrySet的大小不会大于DATA二维数组
                if(size < 0)
                    this.size = 0;
                    // Can't be any bigger than the array:
                else if(size > DATA.length)
                    this.size = DATA.length;
                else
                    this.size = size;
            }

            public int size() {
                return size;
            }

            /**
             * EntrySet的内部类Iter,这是重点，就是由于该接口的实现使EntrySet好像填满的错觉，实际是调用了该接口的原因
             */
            private class Iter implements Iterator<Map.Entry<String,String>> {
                // Iterator持有的单一Entry对象
                private Entry entry = new Entry(-1); //(此时index=-1)这个Entry是我们自定义的net.mindview.util.Countries.FlyweightMap.Entry
                public boolean hasNext() {
                    return entry.index < size - 1; //如果自定义Entry的index小于EntrySet最大索引数，判断还有元素
                }
                public Map.Entry<String,String> next() { //每次调用该next方法，Entry中的index都会自增使其指向下一个元素
                    entry.index++; //用于
                    return entry;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            public Iterator<Map.Entry<String,String>> iterator() {
                System.out.println("调用了自定义的iterator");
                return new Iter();
            }
        }


        private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);

        //FlyweightMap实现的entrySet方法(这里Map.Entry不能去掉Map，因为自定义了一个私有静态内部类Entry)
        public Set<Map.Entry<String,String>> entrySet() {
            return entries;
        }

    }
    //////////////////////////----------------------------------////////////////////////////////////

    // 产生一个包含指定尺寸的的EntrySet的FlyweightMap
    static Map<String,String> select(final int size) {
        return new FlyweightMap() { //匿名内部类
            public Set<Map.Entry<String,String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }
    //这里首先静态初始化，由于创建FlyweightMap对象，开始加载FlyweightMap类中的静态成员entries
    static Map<String,String> map = new FlyweightMap();

    public static Map<String,String> capitals() {
        return map; // The entire map
    }

    public static Map<String,String> capitals(int size) {
        Map<String, String> map = select(size);// A partial map
        return map;
    }

    static List<String> names = new ArrayList<String>(map.keySet());

    // All the names:
    public static List<String> names() {
        return names;
    }

    // A partial list:
    public static List<String> names(int size) {
        Set<String> keySet = select(size).keySet(); //这里在调用FlyweightMap的keySet()方法，实际就是调用AbstractMap的keySet()方法，里面调用了我们FlyweightMap实现的entrySet()方法和iterator()方法
        return new ArrayList<String>(keySet);
    }

    public static void main(String[] args) {
        FlyweightMap.EntrySet entries = new FlyweightMap.EntrySet(DATA.length);
        //重点注意：EntrySet里的Iterator因为持有Entry对象
        //System.out.println(entries); //调用AbstractCollection的toString()方法，而它的toString()里调用了iterator()方法迭代拼接
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry); //实际上这个for循环里的entry都是Iter里持有的Entry entry = new Entry(-1)同一个引用，只是每次遍历调用Iter的next方法改变了hashcode
            /*String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key: "+key + " value: "+value);*/
        }
        print(capitals(10)); //这里调用的是AbstractMap的toString()方法，在该toString方法中调用了map中的entrySet的iterator()方法，因此产生的结果
        print(names(10));
        print(new HashMap<String,String>(capitals(3)));
        print(new LinkedHashMap<String,String>(capitals(3)));
        print(new TreeMap<String,String>(capitals(3)));
        print(new Hashtable<String,String>(capitals(3)));
        print(new HashSet<String>(names(6)));
        print(new LinkedHashSet<String>(names(6)));
        print(new TreeSet<String>(names(6)));
        print(new ArrayList<String>(names(6)));
        print(new LinkedList<String>(names(6)));
        print(capitals().get("BRAZIL"));
    }
} /* Output:
{ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BULGARIA=Sofia, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui}
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC]
{BENIN=Porto-Novo, ANGOLA=Luanda, ALGERIA=Algiers}
{ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo}
{ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo}
{ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo}
[BULGARIA, BURKINA FASO, BOTSWANA, BENIN, ANGOLA, ALGERIA]
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
Brasilia
*///:~
