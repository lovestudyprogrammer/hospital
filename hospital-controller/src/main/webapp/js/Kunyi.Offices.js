Kunyi.Offices = $.ajax({
        type:"POST",
        url:"Offices/Department",
        dataType:"JSON",
        async:false,
        success:function(data){
            alert("成功")
            return data;
        },
        error:function(){
            alert("失败")
        }
    });

/*Kunyi.Offices = [{
    DepID: 16,
    DepName: "国际医疗中心",
    Offices: [{OID: 121, OName: "产科", DNum: 1, DeptCode: "191"}, {
        OID: 122,
        OName: "儿科",
        DNum: 5,
        DeptCode: "192"
    }, {OID: 123, OName: "耳鼻喉科", DNum: 2, DeptCode: "197"}, {
        OID: 124,
        OName: "妇科",
        DNum: 3,
        DeptCode: "190"
    }, {OID: 125, OName: "肝胆外科", DNum: 2, DeptCode: "179"}, {OID: 126, OName: "感染科", DNum: 1, DeptCode: ""}, {
        OID: 127,
        OName: "高血压科",
        DNum: 2,
        DeptCode: "173"
    }, {OID: 128, OName: "骨科", DNum: 3, DeptCode: "181"}, {
        OID: 129,
        OName: "呼吸内科",
        DNum: 6,
        DeptCode: "168"
    }, {OID: 130, OName: "甲状腺外科", DNum: 2, DeptCode: "203"}, {
        OID: 131,
        OName: "介入科",
        DNum: 1,
        DeptCode: "188"
    }, {OID: 132, OName: "康复科", DNum: 1, DeptCode: "209"}, {
        OID: 133,
        OName: "泌尿外科",
        DNum: 3,
        DeptCode: "183"
    }, {OID: 135, OName: "内分泌代谢科", DNum: 0, DeptCode: "171"}, {
        OID: 136,
        OName: "皮肤科",
        DNum: 1,
        DeptCode: "196"
    }, {OID: 137, OName: "全科医学科", DNum: 1, DeptCode: "177"}, {
        OID: 138,
        OName: "乳腺外科",
        DNum: 3,
        DeptCode: "185"
    }, {OID: 139, OName: "神经内科", DNum: 3, DeptCode: "169"}, {
        OID: 140,
        OName: "神经外科",
        DNum: 1,
        DeptCode: "182"
    }, {OID: 141, OName: "肾病风湿免疫科", DNum: 1, DeptCode: "172"}, {
        OID: 142,
        OName: "生殖中心",
        DNum: 2,
        DeptCode: "194"
    }, {OID: 143, OName: "疼痛科", DNum: 1, DeptCode: "199"}, {
        OID: 144,
        OName: "胃肠外科",
        DNum: 2,
        DeptCode: "180"
    }, {OID: 145, OName: "消化内科", DNum: 3, DeptCode: "170"}, {
        OID: 146,
        OName: "心血管内科",
        DNum: 6,
        DeptCode: "167"
    }, {OID: 147, OName: "心血管外科", DNum: 2, DeptCode: "184"}, {
        OID: 148,
        OName: "胸外科",
        DNum: 1,
        DeptCode: "186"
    }, {OID: 149, OName: "血管瘤科", DNum: 1, DeptCode: "189"}, {
        OID: 150,
        OName: "血液内科",
        DNum: 1,
        DeptCode: "174"
    }, {OID: 151, OName: "遗传中心", DNum: 2, DeptCode: "198"}, {
        OID: 152,
        OName: "营养科",
        DNum: 2,
        DeptCode: "202"
    }, {OID: 153, OName: "医学美容", DNum: 0, DeptCode: "205"}, {
        OID: 154,
        OName: "中医科",
        DNum: 1,
        DeptCode: "178"
    }, {OID: 155, OName: "肿瘤内科", DNum: 1, DeptCode: "175"}, {
        OID: 156,
        OName: "变态反应科",
        DNum: 1,
        DeptCode: ""
    }, {OID: 157, OName: "小儿外科", DNum: 1, DeptCode: "206"}, {
        OID: 158,
        OName: "眼科",
        DNum: 3,
        DeptCode: "195"
    }, {OID: 159, OName: "心肺功能科", DNum: 2, DeptCode: "210"}, {OID: 160, OName: "医学心理科", DNum: 1, DeptCode: "208"}]
}, {
    DepID: 1,
    DepName: "内科临床医学部",
    Offices: [{OID: 11, OName: "呼吸内科", DNum: 34, DeptCode: "124"}, {
        OID: 12,
        OName: "神经内科",
        DNum: 40,
        DeptCode: "123"
    }, {OID: 13, OName: "消化内科", DNum: 33, DeptCode: "121"}, {
        OID: 16,
        OName: "感染性疾病科",
        DNum: 10,
        DeptCode: "132"
    }, {OID: 7, OName: "中医科", DNum: 11, DeptCode: "139"}, {OID: 4, OName: "内分泌科", DNum: 26, DeptCode: "126"}, {
        OID: 3,
        OName: "血液内科",
        DNum: 21,
        DeptCode: "122"
    }, {OID: 6, OName: "肾病风湿免疫科", DNum: 21, DeptCode: "125"}, {
        OID: 5,
        OName: "肿瘤内科",
        DNum: 15,
        DeptCode: "127"
    }, {OID: 98, OName: "血液病研究所", DNum: 14, DeptCode: ""}, {OID: 2, OName: "过敏反应科（变态反应科）", DNum: 10, DeptCode: "161"}]
}, {
    DepID: 2,
    DepName: "外科临床医学部",
    Offices: [{OID: 27, OName: "胸外科", DNum: 17, DeptCode: "104"}, {
        OID: 42,
        OName: "胸部肿瘤诊疗中心",
        DNum: 11,
        DeptCode: ""
    }, {OID: 120, OName: "肺移植中心", DNum: 14, DeptCode: ""}, {
        OID: 29,
        OName: "肝胆胰腺外科",
        DNum: 31,
        DeptCode: "110"
    }, {OID: 31, OName: "胃肠外科一病区", DNum: 12, DeptCode: ""}, {
        OID: 45,
        OName: "胃肠外科二病区",
        DNum: 5,
        DeptCode: ""
    }, {OID: 28, OName: "胃肠外科三病区（微创外科中心）", DNum: 12, DeptCode: ""}, {
        OID: 23,
        OName: "骨科",
        DNum: 40,
        DeptCode: "113"
    }, {OID: 34, OName: "神经外科", DNum: 30, DeptCode: "107"}, {
        OID: 43,
        OName: "乳腺外科",
        DNum: 10,
        DeptCode: "109"
    }, {OID: 105, OName: "甲状腺外科", DNum: 7, DeptCode: "118"}, {
        OID: 134,
        OName: "男科与能量医学科",
        DNum: 0,
        DeptCode: "162"
    }, {OID: 24, OName: "泌尿外科", DNum: 26, DeptCode: "111"}, {
        OID: 36,
        OName: "血管瘤科",
        DNum: 10,
        DeptCode: "130"
    }, {OID: 40, OName: "整形美容外科", DNum: 16, DeptCode: "114"}, {
        OID: 22,
        OName: "介入科",
        DNum: 24,
        DeptCode: "131"
    }, {OID: 68, OName: "小儿外科", DNum: 7, DeptCode: "117"}, {OID: 46, OName: "手术室", DNum: 0, DeptCode: ""}, {
        OID: 18,
        OName: "麻醉科",
        DNum: 11,
        DeptCode: ""
    }, {OID: 100, OName: "肾移植中心", DNum: 4, DeptCode: ""}, {
        OID: 162,
        OName: "脊柱脊髓外科",
        DNum: 17,
        DeptCode: "165"
    }, {OID: 163, OName: "重症肌无力科", DNum: 2, DeptCode: "218"}, {
        OID: 115,
        OName: "手外科",
        DNum: 7,
        DeptCode: "119"
    }, {OID: 116, OName: "肝移植病区", DNum: 14, DeptCode: ""}, {OID: 119, OName: "肛肠科", DNum: 0, DeptCode: "155"}]
}, {
    DepID: 10,
    DepName: "妇儿临床医学部",
    Offices: [{OID: 56, OName: "妇科", DNum: 46, DeptCode: "133"}, {
        OID: 114,
        OName: "产科",
        DNum: 10,
        DeptCode: "134"
    }, {OID: 52, OName: "儿科", DNum: 33, DeptCode: "135"}, {OID: 48, OName: "生殖医院", DNum: 38, DeptCode: "136"}, {
        OID: 55,
        OName: "医学遗传中心",
        DNum: 15,
        DeptCode: "137"
    }]
}, {
    DepID: 13,
    DepName: "心血管病医院",
    Offices: [{OID: 8, OName: "心内科", DNum: 51, DeptCode: "120"}, {
        OID: 33,
        OName: "心外科",
        DNum: 18,
        DeptCode: "103"
    }, {OID: 51, OName: "高血压科", DNum: 10, DeptCode: "128"}, {
        OID: 96,
        OName: "血管外科",
        DNum: 11,
        DeptCode: "116"
    }, {OID: 110, OName: "儿童心脏中心", DNum: 15, DeptCode: ""}]
}, {
    DepID: 3,
    DepName: "康馨医学部",
    Offices: [{OID: 57, OName: "神经内科康馨病房", DNum: 8, DeptCode: ""}, {
        OID: 101,
        OName: "呼吸内科康馨病房",
        DNum: 5,
        DeptCode: ""
    }, {OID: 58, OName: "心内科康馨病房", DNum: 6, DeptCode: ""}, {
        OID: 102,
        OName: "康馨综合病房",
        DNum: 3,
        DeptCode: ""
    }, {OID: 117, OName: "全科医学科", DNum: 14, DeptCode: "146"}]
}, {
    DepID: 6,
    DepName: "综合临床医学部",
    Offices: [{OID: 35, OName: "疼痛科", DNum: 7, DeptCode: "142"}, {
        OID: 38,
        OName: "康复医学科",
        DNum: 25,
        DeptCode: "143"
    }, {OID: 39, OName: "肿瘤放疗科", DNum: 11, DeptCode: "115"}, {
        OID: 41,
        OName: "皮肤科",
        DNum: 21,
        DeptCode: "140"
    }, {OID: 44, OName: "口腔科", DNum: 33, DeptCode: "141"}, {OID: 47, OName: "耳鼻咽喉头颈外科", DNum: 27, DeptCode: "138"}]
}, {
    DepID: 15,
    DepName: "重症医学部",
    Offices: [{OID: 37, OName: "重症医学部", DNum: 25, DeptCode: ""}, {OID: 161, OName: "神经外科ICU", DNum: 0, DeptCode: ""}]
}, {
    DepID: 4,
    DepName: "门诊部",
    Offices: [{OID: 93, OName: "门诊办公室", DNum: 0, DeptCode: ""}, {
        OID: 64,
        OName: "神经电生理（肌病诊室）",
        DNum: 4,
        DeptCode: "147"
    }, {OID: 61, OName: "知名专家特需门诊", DNum: 22, DeptCode: "145"}, {
        OID: 63,
        OName: "内镜中心",
        DNum: 1,
        DeptCode: ""
    }, {OID: 107, OName: "计划免疫门诊", DNum: 0, DeptCode: ""}]
}, {DepID: 14, DepName: "体检中心", Offices: [{OID: 62, OName: "健康管理科", DNum: 20, DeptCode: ""}]}, {
    DepID: 5,
    DepName: "急诊医学部",
    Offices: [{OID: 103, OName: "急诊内科", DNum: 0, DeptCode: ""}, {
        OID: 59,
        OName: "急救中心",
        DNum: 13,
        DeptCode: ""
    }, {OID: 104, OName: "急诊创伤外科", DNum: 12, DeptCode: ""}, {OID: 106, OName: "急诊ICU", DNum: 0, DeptCode: ""}]
}, {DepID: 7, DepName: "河南省立眼科医院", Offices: [{OID: 30, OName: "河南省立眼科医院", DNum: 64, DeptCode: "144"}]}, {
    DepID: 8,
    DepName: "医技医学部",
    Offices: [{OID: 10, OName: "影像科", DNum: 25, DeptCode: ""}, {
        OID: 15,
        OName: "核医学科",
        DNum: 5,
        DeptCode: ""
    }, {OID: 19, OName: "超声诊断", DNum: 18, DeptCode: ""}, {OID: 14, OName: "输血科", DNum: 2, DeptCode: ""}, {
        OID: 20,
        OName: "心肺功能科",
        DNum: 7,
        DeptCode: ""
    }, {OID: 21, OName: "检验科", DNum: 20, DeptCode: ""}, {OID: 25, OName: "病理科", DNum: 15, DeptCode: ""}, {
        OID: 26,
        OName: "介入手术室",
        DNum: 1,
        DeptCode: ""
    }, {OID: 97, OName: "营养科", DNum: 13, DeptCode: ""}]
}, {DepID: 9, DepName: "药学部", Offices: [{OID: 9, OName: "药学部", DNum: 24, DeptCode: ""}]}, {
    DepID: 12,
    DepName: "职能部门",
    Offices: [{OID: 113, OName: "保健办", DNum: 0, DeptCode: ""}, {
        OID: 69,
        OName: "院长办公室",
        DNum: 0,
        DeptCode: ""
    }, {OID: 70, OName: "党委办公室", DNum: 0, DeptCode: ""}, {OID: 71, OName: "人事处", DNum: 0, DeptCode: ""}, {
        OID: 72,
        OName: "医务处",
        DNum: 0,
        DeptCode: ""
    }, {OID: 73, OName: "护理部", DNum: 0, DeptCode: ""}, {OID: 74, OName: "医疗发展部", DNum: 0, DeptCode: ""}, {
        OID: 75,
        OName: "研究生处",
        DNum: 0,
        DeptCode: ""
    }, {OID: 76, OName: "采供处", DNum: 0, DeptCode: ""}, {OID: 77, OName: "监察室", DNum: 0, DeptCode: ""}, {
        OID: 78,
        OName: "审计处",
        DNum: 0,
        DeptCode: ""
    }, {OID: 79, OName: "信息中心", DNum: 0, DeptCode: ""}, {OID: 80, OName: "工会", DNum: 0, DeptCode: ""}, {
        OID: 81,
        OName: "团委",
        DNum: 0,
        DeptCode: ""
    }, {OID: 82, OName: "宣传科", DNum: 0, DeptCode: ""}, {OID: 83, OName: "文明办", DNum: 0, DeptCode: ""}, {
        OID: 84,
        OName: "编辑部",
        DNum: 0,
        DeptCode: ""
    }, {OID: 85, OName: "财务处", DNum: 0, DeptCode: ""}, {OID: 86, OName: "后勤管理处", DNum: 0, DeptCode: ""}, {
        OID: 87,
        OName: "保卫处",
        DNum: 0,
        DeptCode: ""
    }, {OID: 88, OName: "离退休职工服务处", DNum: 0, DeptCode: ""}, {OID: 89, OName: "培训中心", DNum: 0, DeptCode: ""}, {
        OID: 90,
        OName: "感染管理科",
        DNum: 0,
        DeptCode: ""
    }, {OID: 91, OName: "科研与学科建设部", DNum: 0, DeptCode: ""}, {OID: 92, OName: "医保办", DNum: 0, DeptCode: ""}, {
        OID: 95,
        OName: "医学装备部",
        DNum: 0,
        DeptCode: ""
    }, {OID: 108, OName: "中心实验室", DNum: 0, DeptCode: ""}, {OID: 112, OName: "教学科", DNum: 0, DeptCode: ""}]
}];*/
