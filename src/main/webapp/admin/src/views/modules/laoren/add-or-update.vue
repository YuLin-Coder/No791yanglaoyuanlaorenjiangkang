<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-account"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}"
        >
            <el-row>
                                                 <input id="updateId" name="id" type="hidden">
                      <el-col :span="12">
                          <el-form-item class="input" v-if="type!='info'" label="老人名称" prop="laorenName">
                              <el-input v-model="ruleForm.laorenName"
                                        placeholder="老人名称" clearable></el-input>
                          </el-form-item>
                          <div v-else>
                              <el-form-item class="input" label="老人名称" prop="laorenName">
                                  <el-input v-model="ruleForm.laorenName"
                                            placeholder="老人名称" readonly></el-input>
                              </el-form-item>
                          </div>
                      </el-col>
                   <el-col :span="12">
                       <el-form-item class="select" v-if="type!='info'"  label="性别" prop="sexTypes">
                           <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                               <el-option
                                       v-for="(item,index) in sexTypesSelectSearch"
                                       v-bind:key="index"
                                       :label="item.indexName"
                                       :value="item.codeIndex">
                               </el-option>
                           </el-select>
                       </el-form-item>
                       <div v-else>
                           <el-form-item class="input" label="性别" prop="sexTypes">
                               <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别" readonly>
                                   <el-option
                                           v-for="(item,index) in sexTypesSelectSearch"
                                           v-bind:key="index"
                                           :label="item.indexName"
                                           :value="item.codeIndex">
                                   </el-option>
                               </el-select>
                           </el-form-item>
                       </div>
                   </el-col>
                      <el-col :span="12">
                          <el-form-item class="input" v-if="type!='info'" label="年龄" prop="laorenAge">
                              <el-input v-model="ruleForm.laorenAge" type="number"
                                        placeholder="年龄"></el-input>
                          </el-form-item>
                          <div v-else>
                              <el-form-item class="input" label="年龄" prop="laorenAge">
                                  <el-input v-model="ruleForm.laorenAge"
                                            placeholder="年龄" readonly></el-input>
                              </el-form-item>
                          </div>
                      </el-col>
                      <el-col :span="12">
                          <el-form-item class="input" v-if="type!='info'" label="家属联系方式" prop="laorenPhone">
                              <el-input v-model="ruleForm.laorenPhone"
                                        placeholder="家属联系方式" clearable></el-input>
                          </el-form-item>
                          <div v-else>
                              <el-form-item class="input" label="家属联系方式" prop="laorenPhone">
                                  <el-input v-model="ruleForm.laorenPhone"
                                            placeholder="家属联系方式" readonly></el-input>
                              </el-form-item>
                          </div>
                      </el-col>
                   <el-col :span="24">
                       <el-form-item class="upload" v-if="type!='info' && !ro.laorenPhoto" label="老人照片" prop="laorenPhoto">
                           <file-upload
                                   tip="点击上传老人照片"
                                   action="file/upload"
                                   :limit="3"
                                   :multiple="true"
                                   :fileUrls="ruleForm.laorenPhoto?ruleForm.laorenPhoto:''"
                                   @change="laorenPhotoUploadChange"
                           ></file-upload>
                       </el-form-item>
                       <div v-else>
                           <el-form-item v-if="ruleForm.laorenPhoto" label="老人照片" prop="laorenPhoto">
                               <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.laorenPhoto.split(',')" :src="item" width="100" height="100">
                           </el-form-item>
                       </div>
                   </el-col>
                      <el-col :span="12">
                          <el-form-item class="input" v-if="type!='info'" label="身份证号" prop="laorenIdNumber">
                              <el-input v-model="ruleForm.laorenIdNumber"
                                        placeholder="身份证号" clearable></el-input>
                          </el-form-item>
                          <div v-else>
                              <el-form-item class="input" label="身份证号" prop="laorenIdNumber">
                                  <el-input v-model="ruleForm.laorenIdNumber"
                                            placeholder="身份证号" readonly></el-input>
                              </el-form-item>
                          </div>
                      </el-col>
                     <el-col :span="24">
                         <el-form-item v-if="type!='info'" label="身体情况" prop="laorenContent">
                             <editor
                                     style="min-width: 200px; max-width: 600px;"
                                     v-model="ruleForm.laorenContent"
                                     class="editor"
                                     action="file/upload">
                             </editor>
                         </el-form-item>
                         <div v-else>
                             <el-form-item v-if="ruleForm.laorenContent" label="身体情况" prop="laorenContent">
                                 <span v-html="ruleForm.laorenContent"></span>
                             </el-form-item>
                         </div>
                     </el-col>
                        <el-col :span="12">
                            <el-form-item class="date" v-if="type!='info'" label="入住时间" prop="riqi">
                                <el-date-picker
                                        value-format="yyyy-MM-dd HH:ss:mm"
                                        v-model="ruleForm.laorenTime"
                                        type="datetime"
                                        placeholder="入住时间">
                                </el-date-picker>
                            </el-form-item>
                            <div v-else>
                                <el-form-item class="input" v-if="ruleForm.laorenTime" label="入住时间" prop="laorenTime">
                                    <el-input v-model="ruleForm.laorenTime"
                                              placeholder="入住时间" readonly></el-input>
                                </el-form-item>
                            </div>
                        </el-col>
            </el-row>




            </el-row>
            <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
            <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
            <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>


    </div>
</template>
<script>
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            let self = this

            return {
                addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"rgba(245, 247, 250, 1)","dateIconFontSize":"14px","btnSaveBgColor":"#409EFF","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"#ecf5ff","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"#606266","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"1px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"#606266","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"1px"},
                id: '',
                type: '',
                ro:{
                            laorenName: false,
                            sexTypes: false,
                            laorenAge: false,
                            laorenPhone: false,
                            laorenPhoto: false,
                            laorenIdNumber: false,
                            laorenContent: false,
                            laorenTime: false,
                            createTime: false,
                },
                ruleForm: {
                            laorenName: '',
                            sexTypes: '',
                            laorenAge: '',
                            laorenPhone: '',
                            laorenPhoto: '',
                            laorenIdNumber: '',
                            laorenContent: '',
                            laorenTime: '',
                            createTime: '',
                },
                        sexTypesSelectSearch: [],
                rules: {

                        laorenName: [
                        { required: true, message: '老人名称不能为空', trigger: 'blur' },
                    ],

                        sexTypes: [
                        { required: true, message: '性别不能为空', trigger: 'blur' },
                    ],

                        laorenAge: [
                        { required: true, message: '年龄不能为空', trigger: 'blur' },
                    ],

                        laorenPhone: [
                        { required: true, message: '家属联系方式不能为空', trigger: 'blur' },
                    ],

                        laorenPhoto: [
                        { required: true, message: '老人照片不能为空', trigger: 'blur' },
                    ],

                        laorenIdNumber: [
                        { required: true, message: '身份证号不能为空', trigger: 'blur' },
                    ],

                        laorenContent: [
                        { required: true, message: '身体情况不能为空', trigger: 'blur' },
                    ],

                        laorenTime: [
                        { required: true, message: '入住时间不能为空', trigger: 'blur' },
                    ],

                        createTime: [
                        { required: true, message: '创建时间不能为空', trigger: 'blur' },
                    ],
            },

        };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }else if(this.type=='cross'){
                    var obj = this.$storage.getObj('crossObj');
                    for (var o in obj){

                                 if(o=='laorenName'){
                                     this.ruleForm.laorenName = obj[o];
                                     this.ro.laorenName = true;
                                     continue;
                                 }

                                 if(o=='sexTypes'){
                                     this.ruleForm.sexTypes = obj[o];
                                     this.ro.sexTypes = true;
                                     continue;
                                 }

                                 if(o=='laorenAge'){
                                     this.ruleForm.laorenAge = obj[o];
                                     this.ro.laorenAge = true;
                                     continue;
                                 }

                                 if(o=='laorenPhone'){
                                     this.ruleForm.laorenPhone = obj[o];
                                     this.ro.laorenPhone = true;
                                     continue;
                                 }

                                 if(o=='laorenPhoto'){
                                     this.ruleForm.laorenPhoto = obj[o];
                                     this.ro.laorenPhoto = true;
                                     continue;
                                 }

                                 if(o=='laorenIdNumber'){
                                     this.ruleForm.laorenIdNumber = obj[o];
                                     this.ro.laorenIdNumber = true;
                                     continue;
                                 }

                                 if(o=='laorenContent'){
                                     this.ruleForm.laorenContent = obj[o];
                                     this.ro.laorenContent = true;
                                     continue;
                                 }

                                 if(o=='laorenTime'){
                                     this.ruleForm.laorenTime = obj[o];
                                     this.ro.laorenTime = true;
                                     continue;
                                 }

                                 if(o=='createTime'){
                                     this.ruleForm.createTime = obj[o];
                                     this.ro.createTime = true;
                                     continue;
                                 }
                    }
                }
                // 获取用户信息
                this.$http({
                    url: `${this.$storage.get('sessionTable')}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                    var json = data.data;
                } else {
                    this.$message.error(data.msg);
                }
            });



                       /* 查询性别信息*/
                    this.$http({
                        url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
                        method: "get"
                    }).then(({data}) => {
                        if (data && data.code === 0) {
                          this.sexTypesSelectSearch = data.data.list;
                      } else {
                          this.$message.error(data.msg);
                      }
                    });








            },
            // 多级联动参数
            info(id) {
                this.$http({
                    url: `laoren/info/${id}`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                    this.ruleForm = data.data;
                } else {
                    this.$message.error(data.msg);
                }
            });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url: `laoren/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                            this.$message({
                                message: "操作成功",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                this.parent.showFlag = true;
                            this.parent.addOrUpdateFlag = false;
                            this.parent.xueshengCrossAddOrUpdateFlag = false;
                            this.parent.search();
                        }
                        });
                        } else {
                            this.$message.error(data.msg);
                        }
                    });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.xueshengCrossAddOrUpdateFlag = false;
            },

                    laorenPhotoUploadChange(fileUrls) {
                                this.ruleForm.laorenPhoto = fileUrls;
                                 this.addEditUploadStyleChange()
                    },
            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                    el.style.height = this.addEditForm.inputHeight
                el.style.color = this.addEditForm.inputFontColor
                el.style.fontSize = this.addEditForm.inputFontSize
                el.style.borderWidth = this.addEditForm.inputBorderWidth
                el.style.borderStyle = this.addEditForm.inputBorderStyle
                el.style.borderColor = this.addEditForm.inputBorderColor
                el.style.borderRadius = this.addEditForm.inputBorderRadius
                el.style.backgroundColor = this.addEditForm.inputBgColor
            })
                document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                    el.style.lineHeight = this.addEditForm.inputHeight
                el.style.color = this.addEditForm.inputLableColor
                el.style.fontSize = this.addEditForm.inputLableFontSize
            })
                // select
                document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                    el.style.height = this.addEditForm.selectHeight
                el.style.color = this.addEditForm.selectFontColor
                el.style.fontSize = this.addEditForm.selectFontSize
                el.style.borderWidth = this.addEditForm.selectBorderWidth
                el.style.borderStyle = this.addEditForm.selectBorderStyle
                el.style.borderColor = this.addEditForm.selectBorderColor
                el.style.borderRadius = this.addEditForm.selectBorderRadius
                el.style.backgroundColor = this.addEditForm.selectBgColor
            })
                document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                    el.style.lineHeight = this.addEditForm.selectHeight
                el.style.color = this.addEditForm.selectLableColor
                el.style.fontSize = this.addEditForm.selectLableFontSize
            })
                document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                    el.style.color = this.addEditForm.selectIconFontColor
                el.style.fontSize = this.addEditForm.selectIconFontSize
            })
                // date
                document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                    el.style.height = this.addEditForm.dateHeight
                el.style.color = this.addEditForm.dateFontColor
                el.style.fontSize = this.addEditForm.dateFontSize
                el.style.borderWidth = this.addEditForm.dateBorderWidth
                el.style.borderStyle = this.addEditForm.dateBorderStyle
                el.style.borderColor = this.addEditForm.dateBorderColor
                el.style.borderRadius = this.addEditForm.dateBorderRadius
                el.style.backgroundColor = this.addEditForm.dateBgColor
            })
                document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                    el.style.lineHeight = this.addEditForm.dateHeight
                el.style.color = this.addEditForm.dateLableColor
                el.style.fontSize = this.addEditForm.dateLableFontSize
            })
                document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                    el.style.color = this.addEditForm.dateIconFontColor
                el.style.fontSize = this.addEditForm.dateIconFontSize
                el.style.lineHeight = this.addEditForm.dateHeight
            })
                // upload
                let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                    el.style.width = this.addEditForm.uploadHeight
                el.style.height = this.addEditForm.uploadHeight
                el.style.borderWidth = this.addEditForm.uploadBorderWidth
                el.style.borderStyle = this.addEditForm.uploadBorderStyle
                el.style.borderColor = this.addEditForm.uploadBorderColor
                el.style.borderRadius = this.addEditForm.uploadBorderRadius
                el.style.backgroundColor = this.addEditForm.uploadBgColor
            })
                document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                    el.style.lineHeight = this.addEditForm.uploadHeight
                el.style.color = this.addEditForm.uploadLableColor
                el.style.fontSize = this.addEditForm.uploadLableFontSize
            })
                document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                    el.style.color = this.addEditForm.uploadIconFontColor
                el.style.fontSize = this.addEditForm.uploadIconFontSize
                el.style.lineHeight = iconLineHeight
                el.style.display = 'block'
            })
                // 多文本输入框
                document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                    el.style.height = this.addEditForm.textareaHeight
                el.style.color = this.addEditForm.textareaFontColor
                el.style.fontSize = this.addEditForm.textareaFontSize
                el.style.borderWidth = this.addEditForm.textareaBorderWidth
                el.style.borderStyle = this.addEditForm.textareaBorderStyle
                el.style.borderColor = this.addEditForm.textareaBorderColor
                el.style.borderRadius = this.addEditForm.textareaBorderRadius
                el.style.backgroundColor = this.addEditForm.textareaBgColor
            })
                document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                    // el.style.lineHeight = this.addEditForm.textareaHeight
                    el.style.color = this.addEditForm.textareaLableColor
                el.style.fontSize = this.addEditForm.textareaLableFontSize
            })
                // 保存
                document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                    el.style.width = this.addEditForm.btnSaveWidth
                el.style.height = this.addEditForm.btnSaveHeight
                el.style.color = this.addEditForm.btnSaveFontColor
                el.style.fontSize = this.addEditForm.btnSaveFontSize
                el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                el.style.borderColor = this.addEditForm.btnSaveBorderColor
                el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                el.style.backgroundColor = this.addEditForm.btnSaveBgColor
            })
                // 返回
                document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                    el.style.width = this.addEditForm.btnCancelWidth
                el.style.height = this.addEditForm.btnCancelHeight
                el.style.color = this.addEditForm.btnCancelFontColor
                el.style.fontSize = this.addEditForm.btnCancelFontSize
                el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                el.style.borderColor = this.addEditForm.btnCancelBorderColor
                el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                el.style.backgroundColor = this.addEditForm.btnCancelBgColor
            })
            })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                    el.style.width = this.addEditForm.uploadHeight
                el.style.height = this.addEditForm.uploadHeight
                el.style.borderWidth = this.addEditForm.uploadBorderWidth
                el.style.borderStyle = this.addEditForm.uploadBorderStyle
                el.style.borderColor = this.addEditForm.uploadBorderColor
                el.style.borderRadius = this.addEditForm.uploadBorderRadius
                el.style.backgroundColor = this.addEditForm.uploadBgColor
            })
            })
            },
        }
    };
</script>
<style lang="scss">
    .editor {
        height: 500px;

    & /deep/ .ql-container {
          height: 310px;
      }
    }
    .amap-wrapper {
        width: 100%;
        height: 500px;
    }
    .search-box {
        position: absolute;
    }
    .addEdit-block {
        margin: -10px;
    }
    .detail-form-account {
        padding: 12px;
    }
    .btn .el-button {
        padding: 0;
    }
</style>
