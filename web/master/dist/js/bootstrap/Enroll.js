// ������js code

//ȫ�ֱ���
var A = 5;
var B = 3;

var playerCnt = 1;
var judgeCnt = 1;
var couchCnt = 1;

//������������Ŀ��Ϣ
var array = new Array(42);

function loadFemale(check){
    var insertText = '<div class="checkbox" style="width:1000px"><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">����</label><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">�ߵ͸�</label><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">ƽ��ľ</label><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">�������</label><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">�Ĵ�</label><label></label></div>';
    var checktxt='checkbo'+check;
    document.getElementById(checktxt).innerHTML=insertText;
}
function loadMale(check){
    var insertText = '<div class="checkbox" style="width:1000px"><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">����</label><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">˫��</label><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">����</label><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">����</label><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">�������</label><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">����</label><label></label><label><input type="checkbox" name="checkbox' + check + 'Option">�Ĵ�</label><label></label></div>';
    var checktxt='checkbo'+check;
    document.getElementById(checktxt).innerHTML=insertText;
}
//����cookies
function setCookie(c_name, value, expiredays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    document.cookie = c_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
}
function setCookies() {
    setCookie('playerCnt', playerCnt, 1);
    setCookie('judgeCnt', judgeCnt, 1);
    setCookie('couchCnt', couchCnt, 1);
}

//�жϱ�����Ϣ�Ƿ����Ҫ��
function judge() {
    putmessage();
    var jud=0;
    //�ж������Ƿ�����Ҫ�󣬲��������ѣ�����Ϊ��array[0-5]<=A��array[6 - 41] <= B
    var i = 0;
    //�ж�������Ա�����
    while (i < 6) {
        if (array[i] >= A)
        {
            jud = 1;
            if (i == 0)
                alert("7-8���������������������");
            else if(i==1)
                alert("7-8�����Ů��������������");
            else if (i == 2)
                alert("9-10���������������������");
            else if (i == 3)
                alert("9-10�����Ů��������������");
            else if (i == 4)
                alert("11-12���������������������");
            else
                alert("11-12�����Ů��������������");
        }
        i++;
    }
    clear(jud);
    var jage;
    var jsex;
    var jproject;
    while (i < 42) {
        //���������������
        if (array[i] >= B) {
            jud = 2;
            //��������&�Ա���Ϣ
            if ((i >= 21) && (i <= 27)) {
                jage = "7-8�����";
                jsex = "����";
            }
            else if (i <= 10) {
                jage = "7-8�����";
                jsex = "Ů��";
            }
            else if ((i >= 28) && (i <= 34)) {
                jage = "9-10�����";
                jsex = "����";
            }
            else if ((i >= 11) && (i <= 15)) {
                jage = "9-10�����";
                jsex = "Ů��";
            }
            else if ((i >= 35) && (i <= 41)) {
                jage = "11-12�����";
                jsex = "����";
            }
            else if ((i >= 16) && (i <= 20)) {
                jage = "11-12�����";
                jsex = "Ů��";
            }
            //������Ŀ
            if ((i == 21) || (i == 28) || (i == 35)) {
                jproject = "����";
            }
            else if ((i == 22) || (i == 29) || (i == 36)) {
                jproject = "˫��";
            }
            else if ((i == 23) || (i == 30) || (i == 37)) {
                jproject = "����";
            }
            else if ((i == 24) || (i == 31) || (i == 38)) {
                jproject = "����";
            }
            else if ((i == 25) || (i == 32) || (i == 39)) {
                jproject = "�������";
            }
            else if ((i == 26) || (i == 33) || (i == 40)) {
                jproject = "����";
            }
            else if ((i == 27) || (i == 34) || (i == 41)) {
                jproject = "�Ĵ�";
            }
                //Ů����Ŀ
            else if ((i == 6) || (i == 11) || (i == 16)) {
                jproject = "����";
            }
            else if ((i == 7) || (i == 12) || (i == 17)) {
                jproject = "�ߵ͸�";
            }
            else if ((i == 8) || (i == 13) || (i == 18)) {
                jproject = "ƽ��ľ";
            }
            else if ((i == 9) || (i == 14) || (i == 19)) {
                jproject = "�������";
            }
            else if ((i == 10) || (i == 15) || (i == 20)) {
                jproject = "�Ĵ�";
            }
            //�����Ϣ
            alert(jage + jsex + jproject + "��Ŀ������������");
        }
        i++;
    }
    clear(jud);
}
//�����ѡ��͸�ѡ����Ϣ
function clear(jud) {
    var selectvalue = null;

    if (jud == 1) {
        //��ȡ��ѡ��ѡ�е�ֵ
        var radio = document.getElementsByName("sex" + playerCnt + "Option");
        for (nn = 0; nn < radio.length; nn++) {
            if (radio[nn].checked) {
                radio[nn].checked= false;
                break;
            }
        }
    }
    else if (jud == 2) {
        //��ȡ��ѡ���ֵ
        var checkbox = document.getElementsByName("checkbox" + playerCnt + "Option");
        for (k = 0; k < checkbox.length; k++) {
            if (checkbox[k].checked)
                checkbox[k].checked = false;
        }
    }
    else;
}

//����˶�Ա��Ϣ����
function putmessage() {
    var j = 0;
    while (j < 42) {
        array[j] = 0;
        j++;
    }
    var i = 0;
    while (i < playerCnt) {
        i++;
        //��ȡ��������Ϣ
        var groups = document.getElementById("playergroup" + i);
        //��ȡ�����б���е�ֵ
        var index = groups.selectedIndex;

        //��ȡ��ѡ��ѡ�е�ֵ
        var obj = document.getElementsByName("sex" + i + "Option");
        //��ȡ��ѡ���ֵ
        var checkbox = document.getElementsByName("checkbox" + i + "Option");

        if (index == 0)//7-8������
        {
            //����
            if (obj[0].checked) {
                array[0]++;
                for (k = 0; k < checkbox.length; k++) {
                    if (checkbox[k].checked)
                        array[k + 21]++;
                }
            }
                //Ů��
            else {
                array[1]++;
                for (k = 0; k < checkbox.length; k++) {
                    if (checkbox[k].checked)
                        array[k + 6]++;
                }
            }

        }
        else if (index == 1)//9-10������
        {
            //����
            if (obj[0].checked) {
                array[2]++;
                for (k = 0; k < checkbox.length; k++) {
                    if (checkbox[k].checked)
                        array[k + 28]++;
                }
            }
                //Ů��
            else {
                array[3]++;
                for (k = 0; k < checkbox.length; k++) {
                    if (checkbox[k].checked)
                        array[k + 11]++;
                }
            }
        }
        else//10-11������
        {
            //����
            if (obj[0].checked) {
                array[4]++;
                for (k = 0; k < checkbox.length; k++) {
                    if (checkbox[k].checked)
                        array[k + 35]++;
                }
            }
                //Ů��
            else {
                array[5]++;
                for (k = 0; k < checkbox.length; k++) {
                    if (checkbox[k].checked)
                        array[k + 16]++;
                }
            }
        }
    }
}
//��Ӧ��ɾ������
function delmessage() {
    var i = playerCnt;
    var groups = document.getElementById("playergroup" + i);
    var index = groups.selectedIndex;
    var obj = document.getElementsByName("sex" + i + "Option");
    var checkbox = document.getElementsByName("checkbox" + i + "Option");

    if (index == 0)//7-8������
    {
        //����
        if (obj[0].checked) {
            array[0]--;
            for (k = 0; k < checkbox.length; k++) {
                if (checkbox[k].checked)
                    array[k + 21]--;
            }
        }
            //Ů��
        else {
            array[1]--;
            for (k = 0; k < checkbox.length; k++) {
                if (checkbox[k].checked)
                    array[k + 6]--;
            }
        }

    }
    else if (index == 1)//9-10������
    {
        if (obj[0].checked) {
            array[2]--;
            for (k = 0; k < checkbox.length; k++) {
                if (checkbox[k].checked)
                    array[k + 28]--;
            }
        }
        else {
            array[3]--;
            for (k = 0; k < checkbox.length; k++) {
                if (checkbox[k].checked)
                    array[k + 11]--;
            }
        }
    }
    else//10-11������
    {
        if (obj[0].checked) {
            array[4]--;
            for (k = 0; k < checkbox.length; k++) {
                if (checkbox[k].checked)
                    array[k + 35]--;
            }
        }
        else {
            array[5]--;
            for (k = 0; k < checkbox.length; k++) {
                if (checkbox[k].checked)
                    array[k + 16]--;
            }
        }
    }
}

//�˶�Ա������
function insRow()
{
    putmessage();
    playerCnt += 1;
    var insertText = '<hr><div class="row"><div class="col-xs-3" style="width:150px"><label for="exampleInputEmail1">����</label><input required type="text" class="form-control" placeholder="����" name="playerName' + playerCnt + '"></div><div class="col-xs-3" style="width:150px"><label for="exampleInputEmail1">����</label><input required type="text" class="form-control" placeholder="����" name="playerAge' + playerCnt + '"></div><div class="col-xs-3" style="width:150px"><label for="exampleInputEmail1">���</label><select class="form-control" id="playergroup' + playerCnt + '"><option value ="7-8��" name="group' + playerCnt + 'Option1">7-8��</option><option value ="9-10��" name="group' + playerCnt + 'Option2">9-10��</option><option value="11-12��" name="group' + playerCnt + 'Option1">11-12��</option></select></div><div class="col-xs-3" style="width:100px"><label for="exampleInputEmail1">�Ļ��ɼ�</label><input required type="text" class="form-control" placeholder="����" disabled="disabled"></div><div class="col-xs-3"><label for="exampleInputEmail1">���֤</label><input  required type="text" class="form-control" placeholder="���֤" name="playerID' + playerCnt + '"></div><div class="col-xs-3" style="width:150px"><label for="exampleInputEmail1">�Ա�</label><div class="form-group"><div class="radio"><label><input type="radio" name="sex' + playerCnt + 'Option" id="optionsRadios1" value="option' + playerCnt + '" onClick="loadMale(' + playerCnt + ')">��</label><label><input type="radio" name="sex' + playerCnt + 'Option" id="optionsRadios2" value="option' + playerCnt + '" onClick="loadFemale(' + playerCnt + ')">Ů</label></div></div></div><div class="col-xs-3"><label for="exampleInputEmail1">������Ŀ����ѡ��</label><div  class="form-group" id="checkbo' + playerCnt + '" name="checkbo' + playerCnt + '"><div class="checkbox" style="width:1000px"><label></label><label><input type="checkbox" name="checkbox' + playerCnt + 'Option">����</label><label></label><label><input type="checkbox" name="checkbox' + playerCnt + 'Option">˫��</label><label></label><label><input type="checkbox" name="checkbox' + playerCnt + 'Option">����</label><label></label><label><input type="checkbox" name="checkbox' + playerCnt + 'Option">����</label><label></label><label><input type="checkbox" name="checkbox' + playerCnt + 'Option">�������</label><label></label><label><input type="checkbox" name="checkbox' + playerCnt + 'Option">����</label><label></label><label><input type="checkbox" name="checkbox' + playerCnt + 'Option">�Ĵ�</label><label></label></div></div></div></div><div  id="sporter' + playerCnt + '" ></div>';
    document.getElementById("sporter" + (playerCnt - 1)).innerHTML += insertText;
    document.getElementById("delete").class = "btn btn-danger";
}
//����Ա������
function insRow2()
{
    couchCnt +=1;
    var insertText = '<hr><div class="row"><div class="col-xs-3" style="width:100px"><label for="exampleInputEmail1">����</label><input type="text" class="form-control" placeholder="����"  name="couchName' + couchCnt + '"></div><div class="col-xs-3" style="width:100px"><label for="exampleInputEmail1">�Ա�</label><input type="text" class="form-control" placeholder="�Ա�" name="couchSex' + couchCnt + '"></div><div class="col-xs-4" style="width:200px"><label for="exampleInputEmail1">��ϵ��ʽ</label><input type="text" class="form-control" placeholder="��ϵ��ʽ" name="couchTel' + couchCnt + '"></div><div class="col-xs-5"><label for="exampleInputEmail1">���֤��</label><input type="text" class="form-control" placeholder="���֤��" name="couchID' + couchCnt + '"></div></div></div><div class="box-body"  id="couch' + couchCnt + '"></div>';
    document.getElementById("couch" + (couchCnt - 1)).innerHTML += insertText;
}
//����Ա������
function insRow3() {
    judgeCnt += 1;
    var insertText = '<hr><div class="row"><div class="col-xs-3"><label for="exampleInputEmail1">����</label><input type="text" class="form-control" placeholder="����" name="judgeName' + judgeCnt + '"></div><div class="col-xs-4"><label for="exampleInputEmail1">��ϵ��ʽ</label><input type="text" class="form-control" placeholder="��ϵ��ʽ"  name="judgeTel' + judgeCnt + '"></div><div class="col-xs-5"><label for="exampleInputEmail1">���֤��</label><input type="text" class="form-control" placeholder="���֤��"  name="judgeID' + judgeCnt + '"></div></div></div><div class="box-body"  id="judge' + judgeCnt + '"></div>';
    document.getElementById("judge" + (judgeCnt - 1)).innerHTML += insertText;
}
//�˶�Ա��ɾ��
function delRow() {
    if (playerCnt > 1) {
        delmessage();
        playerCnt--;
        document.getElementById("sporter" + playerCnt).innerHTML = "";
    }
    else
        alert("��������һ���˶�Ա��");
}
//����Ա��ɾ��
function delRow2() {
    if (couchCnt > 1) {
        couchCnt --;
        document.getElementById("couch" + couchCnt).innerHTML = "";
    }
    else
        alert("��������һ��������");
}
//����Ա��ɾ��
function delRow3() {
    if (judgeCnt > 1) {
        judgeCnt --;
        document.getElementById("judge" + judgeCnt).innerHTML = "";
    }
    else
        alert("��������һ�����У�");
}
//�����---�ܾ��û�����鿴������Ϣ����
function disp_alert() {
    alert("����δ�ύ������Ϣ��")
}