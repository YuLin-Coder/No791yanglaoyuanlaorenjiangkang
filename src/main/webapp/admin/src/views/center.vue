<template>
    <div>
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                label-width="80px"
        >
            <el-row>
                <el-col :span="12">
                    <el-form-item v-if="flag=='yonghu'" label="用户名" prop="username">
                        <el-input v-model="ruleForm.username" readonly placeholder="用户名" clearable></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item v-if="flag=='yonghu'" label="姓名" prop="yonghuName">
                        <el-input v-model="ruleForm.yonghuName" placeholder="姓名" clearable></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="flag=='yonghu'" label="头像" prop="yonghuPhoto">
                        <file-upload
                                tip="点击上传头像"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.yonghuPhoto?ruleForm.yonghuPhoto:''"
                                @change="yonghuyonghuPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item v-if="flag=='yonghu'" label="性别" prop="sexTypes">
                        <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                            <el-option
                                    v-for="(item,index) in sexTypesSelectSearch"
                                    v-bind:key="index"
                                    :label="item.indexName"
                                    :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item v-if="flag=='yonghu'" label="联系电话" prop="yonghuPhone">
                        <el-input v-model="ruleForm.yonghuPhone" placeholder="联系电话" clearable></el-input>
                    </el-form-item>
                </el-col>
                <el-form-item v-if="flag=='users'" label="用户名" prop="username">
                    <el-input v-model="ruleForm.username"
                              placeholder="用户名"></el-input>
                </el-form-item>
                <el-col :span="24">
                    <el-form-item>
                        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
    </div>
</template>
<script>
    // 数字，邮件，手机，url，身份证校验
    import {isNumber, isIntNumer, isEmail, isMobile, isPhone, isURL, checkIdCard} from "@/utils/validate";

    export default {
        data() {
            return {
                ruleForm: {},
                flag: '',
                usersFlag: false,
               
               sexTypesSelectSearch: [],
               laorenTypesSelectSearch: [],
            };
        },
        mounted() {
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
			
			
            var table = this.$storage.get("sessionTable");
            this.flag = table;
            this.$http({
                url: `${this.$storage.get("sessionTable")}/session`,
                method: "get"
            }).then(({data}) => {
                if(data && data.code === 0
        )
            {
                this.ruleForm = data.data;
            }
        else
            {
                this.$message.error(data.msg);
            }
        })
            ;
        },
        methods: {
			apply(id){
				this.$confirm(`确定要申请为'非物质文化传承人'吗?`, "提示", {
				        confirmButtonText: "确定",
				        cancelButtonText: "取消",
				        type: "warning",
				    }).then(() => {
				        this.$http({
				        url: "shenqing/apply?id="+id,
				        method: "post",
				        "id":id
				    }).then(({data}) => {
				        if(data && data.code === 0
				)
				    {
				        this.$message({
				            message: "操作成功",
				            type: "success",
				            duration: 1500,
				            onClose: () => {
				            this.search();
				    }
				    })
				        ;
				    }
				else
				    {
				        this.$message.error(data.msg);
				    }
				})
				    ;
				});
			},
            yonghuyonghuPhotoUploadChange(fileUrls) {
                this.ruleForm.yonghuPhoto = fileUrls;
            },
            onUpdateHandler() {
                if ((!this.ruleForm.username) && 'yonghu' == this.flag) {
                    this.$message.error('用户名不能为空');
                    return
                }
                if ((!this.ruleForm.password) && 'yonghu' == this.flag) {
                    this.$message.error('密码不能为空');
                    return
                }
                if ('yonghu' == this.flag && this.ruleForm.yonghuPhone && (!isMobile(this.ruleForm.yonghuPhone))) {
                    this.$message.error(`联系电话应输入手机格式`);
                    return
                }
                if ('yonghu' == this.flag && this.ruleForm.yonghuIdNumber && (!isNumber(this.ruleForm.yonghuIdNumber))) {
                    this.$message.error(`身份证号应输入数字`);
                    return
                }
                this.$http({
                    url: `${this.$storage.get("sessionTable")}/update`,
                    method: "post",
                    data: this.ruleForm
                }).then(({data}) => {
                    if(data && data.code === 0
            )
                {
                    this.$message({
                        message: "修改信息成功",
                        type: "success",
                        duration: 1500,
                        onClose: () => {}
                })
                    ;
                }
            else
                {
                    this.$message.error(data.msg);
                }
            })
                ;
            }
        }
    };
</script>
<style lang="scss" scoped>
</style>
