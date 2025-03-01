package com.su.shopping_manager_api.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.su.shopping_common.pojo.Admin;
import com.su.shopping_common.result.BaseResult;
import com.su.shopping_common.service.AdminService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员控制器
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @DubboReference
    private AdminService adminService;
    //使用在securityConfig中注入到SpringBoot中的密码加密对象
    @Autowired
    private PasswordEncoder encoder;

    /**
     * 新增管理员
     * @param admin
     */
    @PostMapping("/add")
    public BaseResult add(@RequestBody Admin admin){
        //对密码进行加密后存储在数据库
        String password = admin.getPassword();
        password = encoder.encode(password);
        admin.setPassword(password);
        adminService.add(admin);
        return BaseResult.ok();
    }

    /**
     * 修改管理员
     * @param admin
     * @return
     */
    @PostMapping("/update")
    public BaseResult update(@RequestBody Admin admin){
        //如果修改了密码，则对新密码进行加密
        String password = admin.getPassword();
        if(StringUtils.hasText(password)){
            password = encoder.encode(password);
            //将加密后的密码存到数据库
            admin.setPassword(password);
        }
        adminService.update(admin);
        return BaseResult.ok();
    }

    /**
     * 删除管理员和角色
     * @param aid
     * @return
     */
    @DeleteMapping("/delete")
    public BaseResult delete(Long aid){
        adminService.delete(aid);
        return BaseResult.ok();
    }

    /**
     *查询管理员
     * @param aid
     * @return
     */
    @GetMapping("/findById")
    public BaseResult<Admin> findById(Long aid){
        Admin admin = adminService.findById(aid);
        return BaseResult.ok(admin);
    }

    /**
     * 分页查询管理员
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('/admin/search')")
    public BaseResult<Page<Admin>> search(int page, int size){
        Page<Admin> pages = adminService.search(page, size);
        return BaseResult.ok(pages);
    }

    /**
     * 修改管理员角色
     * @param aid
     * @param rids
     * @return
     */
    @PutMapping("updateRoleToAdmin")
    public BaseResult updateRoleToAdmin(Long aid,Long[] rids){
        adminService.updateRoleToAdmin(aid,rids);
        return BaseResult.ok();
    }

    /**
     * 获取登录管理员用户名
     * @return
     */
    @GetMapping("/getUsername")
    public BaseResult<String> getUsername(){
        //1. 获取会话对象
        SecurityContext context = SecurityContextHolder.getContext();
        //2. 获取认证对象
        Authentication authentication = context.getAuthentication();
        //3. 获取用户名
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return BaseResult.ok(username);
    }
}
