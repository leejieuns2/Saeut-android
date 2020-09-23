package com.teamtips.android.saeut.func.map;


class KaKaoLocationAPI{
    LocalMeta LocalMeta;
    TotalAddress[] totalAddressArrayList;

    public void setKaKaoLocationAPI(KaKaoLocationAPI kaKaoLocationAPI) {
        this.LocalMeta = kaKaoLocationAPI.LocalMeta;
        this.totalAddressArrayList = kaKaoLocationAPI.totalAddressArrayList;
    }
}

class LocalMeta {
    Integer total_count;
    Integer pageable_count;
    Boolean is_end;
}

class TotalAddress {
    String address_name;
    String address_type;
    Double x;
    Double y;
    Address address;
    RoadAddress RoadAddress;
}

class Address {
    String address_name;
    String region_1depth_name;
    String region_2depth_name;
    String region_3depth_name;
    String region_3depth_h_name;
    String h_code;
    String b_code;
    String mountain_yn;
    String main_address_no;
    String sub_address_no;
    String zip_code;
    Double x;
    Double y;
}

class RoadAddress {
    String address_name;
    String region_1depth_name;
    String region_2depth_name;
    String region_3depth_name;
    String road_name;
    String underground_yn;
    String main_building_no;
    String sub_building_no;
    String building_name;
    String zone_no;
    Double x;
    Double y;
}

