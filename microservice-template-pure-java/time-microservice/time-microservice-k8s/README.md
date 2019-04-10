### Install Ansible

```bash
sudo python -m pip install -U pip
sudo pip install packaging

git clone https://github.com/ansible/ansible.git
cd ansible
git checkout -b stable-2.7 origin/stable-2.7
git submodule update --init --recursive
sudo make install
```

### Install Ansible K8s Plugin and deps

```bash
sudo pip install openshift
sudo pip2 install openshift
sudo pip3 install openshift

sudo pip install --upgrade requests
sudo pip2 install --upgrade requests
sudo pip3 install --upgrade requests
```

### Make ansible create k8s resources (RUN)
```bash
ansible-playbook main.yml
```

### Check if resources was created?
```bash
alias k=kubectl
k get ns dev
```
