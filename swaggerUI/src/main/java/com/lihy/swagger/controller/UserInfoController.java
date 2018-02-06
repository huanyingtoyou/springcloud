package com.lihy.swagger.controller;

import com.lihy.swagger.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author lihy
 * @date 2017/10/20
 */
@RestController
@RequestMapping(value = "/userInfo", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "用户信息", description = "用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserInfoController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/selectAllUsers", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有的人员信息并分页展示", notes = "查询所有的人员信息并分页展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "跳转到的页数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "size",value = "每页展示的记录数", required = true, paramType = "query")
    })
    public PageInfo selectAllUsers(Integer page, Integer size) {
        page = page == null || page <= 0 ? 1 : page;
        size = size == null || size <= 5 ? 5 : size;
        PageHelper.startPage(page, size);//PageHelper只对紧跟着的第一个SQL语句起作用
        List<UserInfo> userInfoList = getUserInfoList();
        PageInfo pageInfo = new PageInfo(userInfoList);
        return pageInfo;
    }

    /*@ResponseBody
    @RequestMapping(value = "/selectContacts", method = RequestMethod.GET)
    @ApiOperation(value = "查询通讯录人员信息", notes = "查询通讯录人员信息")
    public ResponseDto selectContacts() {
        List<UserInfo> list = service.selectContacts();
        return ControllerUtil.returnDto(true, "成功", list);
    }*/

    /*@ResponseBody
    @RequestMapping(value = "selectByUserNo", method = RequestMethod.GET)
    @ApiOperation(value = "新增人员前先检测用户名是否可用", notes = "新增人员前先检测用户名是否可用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_no", value = "用户输入的用户名", required = true, paramType = "query")
    })
    public ResponseDto selectByUserNo(String user_no) {
        UserInfo userInfo = service.selectByUserNo(user_no);
        if(null == userInfo || "".equals(userInfo.getUserNo())) {
            return ControllerUtil.returnDto(true, "此用户名可用", null);
        }else {
            return ControllerUtil.returnDto(false, "此用户名不可用", null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "insertSelective", method = RequestMethod.POST)
    @ApiOperation(value = "新增人员", notes = "新增人员")
    public ResponseDto insertSelective(UserInfoDto userInfoDto) {
        int count = 0;
        PinyinUtils pinyin = new PinyinUtils();
        try {
            //新增人员之前先检查用户名是否可用
            UserInfo userInfo = service.selectByUserNo(userInfoDto.getUserNo());
            if(null != userInfo && !"".equals(userInfo.getUserNo())) {
                return ControllerUtil.returnDto(false, "此用户名不可用", null);
            }

            if(null != userInfoDto.getUserName() && !"".equals(userInfoDto.getUserName())) {
                //获取姓名拼音并存在对象中
                userInfoDto.setSpellName(pinyin.getPingYin(userInfoDto.getUserName()));
            }else {
                return ControllerUtil.returnDto(false, "请输入姓名", count);
            }

            count = service.insertSelective(userInfoDto);
            if(count <= 0) {
                return ControllerUtil.returnDto(false, "失败", count);
            }else {
                return ControllerUtil.returnDto(true, "成功", count);
            }
        } catch (Exception e) {
            logger.error("userInfo--insertSelective:系统异常");
            return ControllerUtil.returnDto(false, "系统异常", count);
        }
    }

    @ResponseBody
    @RequestMapping(value = "updateByPrimaryKeySelective", method = RequestMethod.POST)
    @ApiOperation(value = "根据id修改人员信息", notes = "根据id修改人员信息")
    public ResponseDto updateByPrimaryKeySelective(UserInfoDto userInfoDto) {
        int count = 0;
        try {
            count = service.updateByPrimaryKeySelective(userInfoDto);
            if(count <= 0) {
                return ControllerUtil.returnDto(false, "失败", count);
            }else {
                return ControllerUtil.returnDto(true, "成功", count);
            }
        } catch (Exception e) {
            logger.error("userInfo--updateByPrimaryKeySelective:系统异常");
            return ControllerUtil.returnDto(false, "系统异常", count);
        }
    }

    @ResponseBody
    @RequestMapping(value = "modifyPwdById", method = RequestMethod.GET)
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "人员信息id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "security_code",value = "验证码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password",value = "新密码", required = true, paramType = "query")
    })
    public ResponseDto updateByPrimaryKeySelective(Integer id, String security_code, String password) {
        int count = 0;
        try {
            //先对验证码是否正确做验证（此处暂未处理）
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setId(id);
            userInfoDto.setPassword(password);
            count = service.modifyPwdById(userInfoDto);
            if(count <= 0) {
                return ControllerUtil.returnDto(false, "失败", count);
            }else {
                return ControllerUtil.returnDto(true, "成功", count);
            }
        } catch (Exception e) {
            logger.error("userInfo--modifyPwdById:系统异常");
            return ControllerUtil.returnDto(false, "系统异常", count);
        }
    }

    @ResponseBody
    @RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.GET)
    @ApiOperation(value = "根据id删除人员信息", notes = "根据id删除人员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "人员信息id", required = true, paramType = "query")
    })
    public ResponseDto deleteByPrimaryKey(Integer id) {
        int count = 0;
        try {
            count = service.deleteByPrimaryKey(id);
            if(count <= 0) {
                return ControllerUtil.returnDto(false, "失败", count);
            }else {
                return ControllerUtil.returnDto(true, "成功", count);
            }
        } catch (Exception e) {
            logger.error("userInfo--deleteByPrimaryKey:系统异常");
            return ControllerUtil.returnDto(false, "系统异常", count);
        }
    }

    @ResponseBody
    @RequestMapping(value = "selectById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id查询人员的所有信息", notes = "根据id查询人员的所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "人员信息id", required = true, paramType = "query")
    })
    public ResponseDto selectById(Integer id) {
        UserInfoDto dto = service.selectById(id);
        return ControllerUtil.returnDto(true, "成功", dto);
    }*/

    public static List<UserInfo> getUserInfoList(){
        List<UserInfo> userInfoList = new ArrayList(3);
        for (int i = 0; i < 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(i);
            userInfo.setUserNo(UUID.randomUUID().toString().replace("-",""));
            userInfo.setUserName("lihy" + i);
            userInfo.setSpellName("lihy" + i);
            userInfo.setPassword("lihy" + i);
            userInfo.setUserPhone("13671981170");
            userInfo.setUserGender(0);
            userInfo.setCreateTime(new Date());
            userInfo.setUpdateTime(new Date());
            userInfoList.add(userInfo);
        }
        return userInfoList;
    }

    public static void main(String[] args) {
        System.out.print(System.currentTimeMillis());
    }
}
